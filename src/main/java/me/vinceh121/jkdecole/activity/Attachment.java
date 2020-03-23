package me.vinceh121.jkdecole.activity;

import com.fasterxml.jackson.annotation.JsonProperty;

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

	@JsonProperty("typeMime")
	public String getMimeType() {
		return this.mimeType;
	}

	@JsonProperty("typeMime")
	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}
}