package me.vinceh121.jkdecole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import me.vinceh121.jkdecole.activity.ActivityContent;
import me.vinceh121.jkdecole.grades.GradeMessage;
import me.vinceh121.jkdecole.messages.CompleteCommunication;
import me.vinceh121.jkdecole.messages.Inbox;
import me.vinceh121.jkdecole.requests.RequestCalendar;
import me.vinceh121.jkdecole.requests.RequestInfoUtilisateur;

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
		this.httpClient = HttpClientBuilder.create().setUserAgent(userAgent).build();
		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
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
		if (autosetEndpoint)
			this.endPoint = Endpoints.getEndpoint(password.substring(0, 2));

		final JsonNode obj = this.makeGetRequest("activation/" + username + "/" + password);
		if (obj == null)
			return false;

		if (obj.get("success").asBoolean()) {
			this.token = obj.get("authtoken").asText();
			this.isConnected = true;
			this.idEstablishment = this.getInfoUtilisateur().getIdEtablissementSelectionne();
			this.idStudent = this.getInfoUtilisateur().getIdEleveSelectionne();
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
		System.out.println(this.makeGetRequest("consulterReleves/idetablissement/" + this.idStudent).toPrettyString());
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
	public Inbox getInbox(int index) throws ClientProtocolException, IOException {
		final JsonNode obj;
		if (index == -1)
			obj = this.makeGetRequest("messagerie/boiteReception");
		else
			obj = this.makeGetRequest("messagerie/boiteReception/" + index);

		return this.mapper.readValue(obj.traverse(), Inbox.class);
	}

	public CompleteCommunication getCommunication(long id) throws ClientProtocolException, IOException {
		final JsonNode obj = this.makeGetRequest("messagerie/communication/" + id);
		return this.mapper.readValue(obj.traverse(), CompleteCommunication.class);
	}

	public RequestInfoUtilisateur getInfoUtilisateur()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest("infoutilisateur").traverse(), RequestInfoUtilisateur.class);
	}

	public int getNumberOfUnreadEmails() throws ClientProtocolException, IOException {
		return this.makeGetRequest("messagerie/info").get("nbMessagesNonLus").asInt();
	}

	public List<Article> getNews() throws ClientProtocolException, IOException {
		final JsonNode obj = this.makeGetRequest("actualites/idetablissement/" + this.idEstablishment);
		final List<Article> news = this.mapper.readValue(obj.traverse(), new TypeReference<List<Article>>() {});
		return news;
	}

	public RequestCalendar getCalendar()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(
				this.makeGetRequest("calendrier/idetablissement/" + this.idEstablishment).traverse(),
				RequestCalendar.class);
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
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public void setEndpoint(final String url) {
		this.endPoint = url;
	}

	public String getEndpoint() {
		return endPoint;
	}

	public void setKdecoleVersion(String kdecoleVers) {
		this.kdecoleVers = kdecoleVers;
	}

	public String getKdecoleVersion() {
		return kdecoleVers;
	}

	private JsonNode makeRequest(final HttpUriRequest req) throws ClientProtocolException, IOException {
		this.dateOfLastRequest = new Date().getTime();
		final JsonNode obj = this.httpClient.execute(req, response -> {
			final int status = response.getStatusLine().getStatusCode();
			if (status != 200)
				System.err.println("Status code: " + status);

			if (response.getEntity() == null)
				return null;

			final ByteArrayOutputStream stream = new ByteArrayOutputStream();
			response.getEntity().writeTo(stream);

			return mapper.readTree(stream.toString());

		});

		if (obj == null)
			return null;

		if (obj.hasNonNull("errmsg")) {
			System.out.println(obj.toPrettyString()); // XXX debug
			throw parseException(obj.get("errmsg"));
		} else
			return obj;
	}

	private JsonNode makeGetRequest(String request) throws ClientProtocolException, IOException {
		if (!request.endsWith("/"))
			request = request + "/";
		final HttpGet get = new HttpGet(this.endPoint + request + "?_=" + new Date().getTime());
		get.setHeader("X-Kdecole-Auth", this.token);
		get.setHeader("X-Kdecole-Date", Long.toString(this.dateOfLastRequest));
		get.setHeader("X-Kdecole-Vers", this.kdecoleVers);
		return this.makeRequest(get);
	}

	private KdecoleException parseException(JsonNode ex) throws JsonParseException, JsonMappingException, IOException {
		return mapper.readValue(mapper.treeAsTokens(ex), KdecoleException.class);
	}

}
