package me.vinceh121.jkdecole;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.JSONArray;
import org.json.JSONException;
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

	public JKdecole(String userAgent) {
		this.httpClient = HttpClientBuilder.create().setUserAgent(userAgent).build();
	}

	public JKdecole() {
		this(DEFAULT_USER_AGENT);
	}

	public JSONObject makeRequest(HttpUriRequest req) {
		dateOfLastRequest = new Date().getTime();
		try {
			return httpClient.execute(req, new ResponseHandler<JSONObject>() {

				public JSONObject handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status != 200) {
						System.err.println("Status code: " + status);
					}

					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					response.getEntity().writeTo(stream);
					try {
						return new JSONObject(stream.toString());
					} catch (JSONException e) {
						return null;
					}
				}
			});
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public JSONObject makeGetRequest(String request) {
		if (!request.endsWith("/"))
			request = request + "/";
		HttpGet get = new HttpGet(endPoint + request + "?_=" + new Date().getTime());
		get.setHeader("X-Kdecole-Auth", token);
		get.setHeader("X-Kdecole-Date", Long.toString(dateOfLastRequest));
		get.setHeader("X-Kdecole-Vers", kdecoleVers);
		return makeRequest(get);
	}

	public JSONArray makeRequestArray(HttpUriRequest req) {
		dateOfLastRequest = new Date().getTime();
		try {
			return httpClient.execute(req, new ResponseHandler<JSONArray>() {

				public JSONArray handleResponse(HttpResponse response) throws ClientProtocolException, IOException {
					ByteArrayOutputStream stream = new ByteArrayOutputStream();
					response.getEntity().writeTo(stream);
					return new JSONArray(stream.toString());
				}
			});
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public void setEndpoint(String url) {
		this.endPoint = url;
	}

	public JSONArray makeGetRequestArray(String request) {
		if (!request.endsWith("/"))
			request = request + "/";
		HttpGet get = new HttpGet(endPoint + request + "?_=" + new Date().getTime());
		get.setHeader("X-Kdecole-Auth", token);
		get.setHeader("X-Kdecole-Date", Long.toString(dateOfLastRequest));
		get.setHeader("X-Kdecole-Vers", kdecoleVers);
		return makeRequestArray(get);
	}

	/**
	 * Attempt to login.
	 * 
	 * @return true if login is successful, false otherwise
	 */
	public boolean login(String username, String password, boolean autosetEndpoint) {
		if (autosetEndpoint)
			endPoint = Endpoints.getEndpoint(password.substring(0, 2));
		

		JSONObject obj = makeGetRequest("activation/" + username + "/" + password);
		if (obj == null)
			return false;

		if (obj.getBoolean("success")) {
			token = obj.getString("authtoken");
			isConnected = true;
			idEtablissement = getInfoUtilisateur().getIdEtablissementSelectionne();
			return true;
		}
		return false;
	}

	public void login(String token) {
		this.token = token;
		isConnected = true;
	}

	public boolean isConnected() {
		return isConnected;
	}

	public MessageInfoUtilisateur getInfoUtilisateur() {
		return MessageInfoUtilisateur.fromJson(makeGetRequest("infoutilisateur"));
	}

	public int getNumberOfUnreadEmails() {
		return makeGetRequest("messagerie/info").getInt("nbMessagesNonLus");
	}

	public Article[] getNews() {
		JSONArray obj = makeGetRequestArray("actualites/idetablissement/" + idEtablissement);
		Article[] news = new Article[obj.length()];
		for (int i = 0; i < news.length; i++) {
			news[i] = Article.fromJson(obj.getJSONObject(i));
		}
		return news;
	}

	public MessageCalendar getCalendar() {
		return MessageCalendar.fromJson(makeGetRequest("calendrier/idetablissement/" + idEtablissement));
	}

	public ActivityContent getContentForActivity(int sessionId, int sessionContentId) {
		return ActivityContent.fromJson(makeGetRequest(
				"contenuActivite/idetablissement/" + idEtablissement + "/" + sessionId + "/" + sessionContentId));
	}

	public String getIdEtablissement() {
		return idEtablissement;
	}

	public void setIdEtablissement(String idEtablissement) {
		this.idEtablissement = idEtablissement;
	}

	public String getToken() {
		return token;
	}

}
