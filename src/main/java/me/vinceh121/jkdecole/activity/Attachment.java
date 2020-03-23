package me.vinceh121.jkdecole.activity;

import org.json.JSONObject;

public class Attachment {
	private int idRessource;
	private String name, url, mimeType;

	public int getIdRessource() {
		return this.idRessource;
	}

	public void setIdRessource(final int idRessource) {
		this.idRessource = idRessource;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getMimeType() {
		return this.mimeType;
	}

	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}

	public static Attachment fromJson(final JSONObject obj) {
		final Attachment att = new Attachment();
		att.idRessource = obj.getInt("idRessource");
		att.name = obj.getString("name");
		att.url = obj.getString("url");
		att.mimeType = obj.getString("typeMime");
		return att;
	}
}
