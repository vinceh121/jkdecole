package me.vinceh121.jkdecole.activity;

import org.json.JSONObject;

public class Attachment {
	private int idRessource;
	private String name, url, mimeType;

	public int getIdRessource() {
		return idRessource;
	}

	public void setIdRessource(int idRessource) {
		this.idRessource = idRessource;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public static Attachment fromJson(JSONObject obj) {
		Attachment att = new Attachment();
		att.idRessource = obj.getInt("idRessource");
		att.name = obj.getString("name");
		att.url = obj.getString("url");
		att.mimeType = obj.getString("typeMime");
		return att;
	}
}
