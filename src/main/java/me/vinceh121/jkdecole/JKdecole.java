package me.vinceh121.jkdecole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import me.vinceh121.jkdecole.activity.ActivityContent;
import me.vinceh121.jkdecole.messages.MessageCalendar;
import me.vinceh121.jkdecole.messages.MessageInfoUtilisateur;

public class JKdecole {
	public static final String DEFAULT_USER_AGENT = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.128 Electron/4.1.5 Safari/537.36";
	private HttpClient httpClient;
	private boolean isConnected = false;
	private String endPoint, token, kdecoleVers = "3.1.22";
	private long dateOfLastRequest = 0;
	private String idEtablissement;

	public JKdecole() {
		this(JKdecole.DEFAULT_USER_AGENT);
	}

	public JKdecole(final String userAgent) {
		this.httpClient = HttpClientBuilder.create().setUserAgent(userAgent).build();
	}

	public void setEndpoint(final String url) {
		this.endPoint = url;
	}

	/**
	 * Attempt to login.
	 *
	 * @return true if login is successful, false otherwise
	 */
	public boolean login(final String username, final String password, final boolean autosetEndpoint) {
		if (autosetEndpoint)
			this.endPoint = Endpoints.getEndpoint(password.substring(0, 2));

		final JSONObject obj = this.makeGetRequest("activation/" + username + "/" + password);
		if (obj == null)
			return false;

		if (obj.getBoolean("success")) {
			this.token = obj.getString("authtoken");
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

	public MessageInfoUtilisateur getInfoUtilisateur() {
		return MessageInfoUtilisateur.fromJson(this.makeGetRequest("infoutilisateur"));
	}

	public int getNumberOfUnreadEmails() {
		return this.makeGetRequest("messagerie/info").getInt("nbMessagesNonLus");
	}

	public Article[] getNews() {
		final JSONArray obj = this.makeGetRequestArray("actualites/idetablissement/" + this.idEtablissement);
		final Article[] news = new Article[obj.length()];
		for (int i = 0; i < news.length; i++)
			news[i] = Article.fromJson(obj.getJSONObject(i));
		return news;
	}

	public MessageCalendar getCalendar() {
		return MessageCalendar.fromJson(this.makeGetRequest("calendrier/idetablissement/" + this.idEtablissement));
	}

	public ActivityContent getContentForActivity(final int sessionId, final int sessionContentId) {
		return ActivityContent.fromJson(this.makeGetRequest(
				"contenuActivite/idetablissement/" + this.idEtablissement + "/" + sessionId + "/" + sessionContentId));
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

	private JSONObject makeRequest(final HttpUriRequest req) {
		this.dateOfLastRequest = new Date().getTime();
		try {
			final JSONObject obj = this.httpClient.execute(req, response -> {
				final int status = response.getStatusLine().getStatusCode();
				if (status != 200)
					System.err.println("Status code: " + status);
	
				final ByteArrayOutputStream stream = new ByteArrayOutputStream();
				response.getEntity().writeTo(stream);
	
				final JSONObject obj1 = new JSONObject(stream.toString());
	
				return obj1;
	
			});
			if (obj.optJSONObject("errmsg") != null)
				throw new KdecoleException(obj.getJSONObject("errmsg"));
			else
				return obj;
		} catch (final ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private JSONObject makeGetRequest(String request) {
		if (!request.endsWith("/"))
			request = request + "/";
		final HttpGet get = new HttpGet(this.endPoint + request + "?_=" + new Date().getTime());
		get.setHeader("X-Kdecole-Auth", this.token);
		get.setHeader("X-Kdecole-Date", Long.toString(this.dateOfLastRequest));
		get.setHeader("X-Kdecole-Vers", this.kdecoleVers);
		return this.makeRequest(get);
	}

	private JSONArray makeRequestArray(final HttpUriRequest req) {
		this.dateOfLastRequest = new Date().getTime();
		try {
			return this.httpClient.execute(req, response -> {
				final ByteArrayOutputStream stream = new ByteArrayOutputStream();
				response.getEntity().writeTo(stream);
				return new JSONArray(stream.toString());
			});
		} catch (final ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (final IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	private JSONArray makeGetRequestArray(String request) {
		if (!request.endsWith("/"))
			request = request + "/";
		final HttpGet get = new HttpGet(this.endPoint + request + "?_=" + new Date().getTime());
		get.setHeader("X-Kdecole-Auth", this.token);
		get.setHeader("X-Kdecole-Date", Long.toString(this.dateOfLastRequest));
		get.setHeader("X-Kdecole-Vers", this.kdecoleVers);
		return this.makeRequestArray(get);
	}

}
