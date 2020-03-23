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
import me.vinceh121.jkdecole.messages.MessageCalendar;
import me.vinceh121.jkdecole.messages.MessageInfoUtilisateur;

public class JKdecole {
	public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.128 Electron/4.1.5 Safari/537.36";
	private final ObjectMapper mapper = new ObjectMapper();
	private HttpClient httpClient;
	private boolean isConnected = false;
	private String endPoint, token, kdecoleVers = "3.5.2";
	private long dateOfLastRequest = 0;
	private String idEtablissement;

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
			this.idEtablissement = this.getInfoUtilisateur().getIdEtablissementSelectionne();
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

	public MessageInfoUtilisateur getInfoUtilisateur()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest("infoutilisateur").traverse(), MessageInfoUtilisateur.class);
	}

	public int getNumberOfUnreadEmails() throws ClientProtocolException, IOException {
		return this.makeGetRequest("messagerie/info").get("nbMessagesNonLus").asInt();
	}

	public List<Article> getNews() throws ClientProtocolException, IOException {
		final JsonNode obj = this.makeGetRequest("actualites/idetablissement/" + this.idEtablissement);
		final List<Article> news = this.mapper.readValue(obj.traverse(), new TypeReference<List<Article>>() {
		});
		return news;
	}

	public MessageCalendar getCalendar()
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(
				this.makeGetRequest("calendrier/idetablissement/" + this.idEtablissement).traverse(),
				MessageCalendar.class);
	}

	public ActivityContent getContentForActivity(final int sessionId, final int sessionContentId)
			throws JsonParseException, JsonMappingException, ClientProtocolException, IOException {
		return this.mapper.readValue(this.makeGetRequest(
				"contenuActivite/idetablissement/" + this.idEtablissement + "/" + sessionId + "/" + sessionContentId)
				.traverse(), ActivityContent.class);
	}

	public String getIdEtablissement() {
		return this.idEtablissement;
	}

	public void setIdEtablissement(final String idEtablissement) {
		this.idEtablissement = idEtablissement;
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

			final ByteArrayOutputStream stream = new ByteArrayOutputStream();
			response.getEntity().writeTo(stream);

			return mapper.readTree(stream.toString());

		});
		System.out.println(obj.toPrettyString());

		if (obj.hasNonNull("errmsg"))
			throw parseException(obj.get("errmsg"));
		else
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
