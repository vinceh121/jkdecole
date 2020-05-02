package me.vinceh121.jkdecole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.vinceh121.jkdecole.entities.Article;
import me.vinceh121.jkdecole.entities.activity.ActivityContent;
import me.vinceh121.jkdecole.entities.grades.GradeMessage;
import me.vinceh121.jkdecole.entities.info.UserInfo;
import me.vinceh121.jkdecole.entities.messages.CompleteCommunication;
import me.vinceh121.jkdecole.entities.messages.Inbox;
import me.vinceh121.jkdecole.entities.time.Calendar;

public class JKdecole {
	public static final String DEFAULT_USER_AGENT
			= "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.128 Electron/4.1.5 Safari/537.36";
	private final ObjectMapper mapper = new ObjectMapper();
	private HttpClient httpClient;
	private boolean isConnected = false;
	private String endPoint, token, kdecoleVers = "3.5.2";
	private long dateOfLastRequest = 0;
	private String idEstablishment, idStudent;

	public JKdecole() {
		this(JKdecole.DEFAULT_USER_AGENT);
	}

	public JKdecole(final String userAgent) {
		this(HttpClientBuilder.create().setUserAgent(userAgent).build());

	}

	public JKdecole(final HttpClient client) {
		this.mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
	}

	/**
	 * Attempt to login.
	 *
	 * @return true if login is successful, false otherwise
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public boolean login(final String username, final String password, final boolean autosetEndpoint)
			throws ClientProtocolException, IOException {
		if (autosetEndpoint) {
			this.endPoint = Endpoints.getEndpoint(password.substring(0, 2));
		}

		final JsonNode obj = this.makeGetRequest("activation/" + username + "/" + password);
		if (obj == null) {
			return false;
		}

		if (obj.get("success").asBoolean()) {
			this.token = obj.get("authtoken").asText();
			this.isConnected = true;
			this.idEstablishment = this.getUserInfo().getIdEtablissementSelectionne();
			this.idStudent = this.getUserInfo().getIdEleveSelectionne();
			return true;
		}
		return false;
	}

	public void login(final String token) {
		this.token = token;
		this.isConnected = true;
	}

	public boolean isConnected() {
		return this.isConnected;
	}

	/**
	 * This method needs to be called to notify the backend that the app has started
	 * and causes the loading of various data such as grades.
	 */
	public void sendStarting() throws ClientProtocolException, IOException {
		this.makeGetRequest("starting");
	}

	public void getEstablishmentReportCards() throws ClientProtocolException, IOException { // TODO
		System.out.println(
				this.makeGetRequest("consulterReleves/idetablissement/" + this.idEstablishment).toPrettyString());
	}

	public void getStudentReportCards() throws ClientProtocolException, IOException { // TODO
		System.out.println(this.makeGetRequest("consulterReleves/ideleve/" + this.idStudent).toPrettyString());
	}

	/**
	 * Might need to be called multiple times until backend has loaded grades from
	 * Pronote
	 *
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public GradeMessage getEstablishmentGrades() throws ClientProtocolException, IOException {
		return this.mapper.readValue(
				this.makeGetRequest("consulterNotes/idetablissement" + this.idEstablishment).traverse(),
				GradeMessage.class);
	}

	/**
	 * Might need to be called multiple times until backend has loaded grades from
	 * Pronote
	 *
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public GradeMessage getStudentGrades() throws ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest("consulterNotes/ideleve/" + this.idStudent).traverse(),
				GradeMessage.class);
	}

	/**
	 *
	 * @param index -1 for not specified
	 * @throws IOException
	 * @throws ClientProtocolException
	 */
	public Inbox getInbox(final int index) throws ClientProtocolException, IOException {
		final JsonNode obj;
		if (index == -1) {
			obj = this.makeGetRequest("messagerie/boiteReception");
		} else {
			obj = this.makeGetRequest("messagerie/boiteReception/" + index);
		}

		return this.mapper.readValue(obj.traverse(), Inbox.class);
	}

	public int getNumberOfUnreadEmails() throws ClientProtocolException, IOException {
		return this.makeGetRequest("messagerie/info").get("nbMessagesNonLus").asInt();
	}

	public CompleteCommunication getCommunication(final long id) throws ClientProtocolException, IOException {
		final JsonNode obj = this.makeGetRequest("messagerie/communication/" + id);
		return this.mapper.readValue(obj.traverse(), CompleteCommunication.class);
	}

	public void deleteCommunication(final long id) throws ClientProtocolException, IOException {
		this.makePutRequest("messagerie/communication/supprimer/" + id);
	}

	public UserInfo getUserInfo()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest("infoutilisateur").traverse(), UserInfo.class);
	}

	public List<Article> getNews() throws ClientProtocolException, IOException {
		final JsonNode obj = this.makeGetRequest("actualites/idetablissement/" + this.idEstablishment);
		final List<Article> news = this.mapper.readValue(obj.traverse(), new TypeReference<List<Article>>() {});
		return news;
	}

	public Calendar getCalendar()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(
				this.makeGetRequest("calendrier/idetablissement/" + this.idEstablishment).traverse(),
				Calendar.class);
	}

	public ActivityContent getContentForActivity(final int sessionId, final int sessionContentId)
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest(
				"contenuActivite/idetablissement/" + this.idEstablishment + "/" + sessionId + "/" + sessionContentId)
				.traverse(), ActivityContent.class);
	}

	public String getIdEstablishment() {
		return this.idEstablishment;
	}

	public void setIdEstablishment(final String idEtablissement) {
		this.idEstablishment = idEtablissement;
	}

	public String getIdStudent() {
		return this.idStudent;
	}

	public void setIdStudent(final String idStudent) {
		this.idStudent = idStudent;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(final String token) {
		this.token = token;
	}

	public void setEndpoint(final String url) {
		this.endPoint = url;
	}

	public String getEndpoint() {
		return this.endPoint;
	}

	public void setKdecoleVersion(final String kdecoleVers) {
		this.kdecoleVers = kdecoleVers;
	}

	public String getKdecoleVersion() {
		return this.kdecoleVers;
	}

	private JsonNode makeRequest(final HttpUriRequest req) throws ClientProtocolException, IOException {
		this.dateOfLastRequest = new Date().getTime();
		final JsonNode obj = this.httpClient.execute(req, response -> {
			final int status = response.getStatusLine().getStatusCode();
			if (status != 200) {
				System.err.println("Status code: " + status);
			}

			if (response.getEntity() == null) {
				return null;
			}

			final ByteArrayOutputStream stream = new ByteArrayOutputStream();
			response.getEntity().writeTo(stream);

			return this.mapper.readTree(stream.toString());

		});

		if (obj == null) {
			return null;
		}

		if (obj.hasNonNull("errmsg")) {
			throw this.parseException(obj.get("errmsg"));
		} else {
			return obj;
		}
	}

	private JsonNode makeGetRequest(String request) throws ClientProtocolException, IOException {
		if (!request.endsWith("/")) {
			request = request + "/";
		}
		final HttpGet get = new HttpGet(this.endPoint + request + "?_=" + new Date().getTime());
		this.addHeaders(get);
		return this.makeRequest(get);
	}

	private JsonNode makePutRequest(String request) throws ClientProtocolException, IOException {
		if (!request.endsWith("/")) {
			request = request + "/";
		}
		final HttpPut put = new HttpPut(this.endPoint + request + "?_=" + new Date().getTime());
		this.addHeaders(put);
		return this.makeRequest(put);
	}

	private void addHeaders(final HttpUriRequest request) {
		request.setHeader("X-Kdecole-Auth", this.token);
		request.setHeader("X-Kdecole-Date", Long.toString(this.dateOfLastRequest));
		request.setHeader("X-Kdecole-Vers", this.kdecoleVers);
	}

	private KdecoleException parseException(final JsonNode ex)
			throws JsonParseException, JsonMappingException, IOException {
		return this.mapper.readValue(this.mapper.treeAsTokens(ex), KdecoleException.class);
	}

}
