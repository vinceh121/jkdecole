package me.vinceh121.jkdecole.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
	@JsonProperty("idRessource")
	private long id;
	private String url;
	private String name;
	@JsonProperty("typeMIME")
	private String mimeType;

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getMimeType() {
		return this.mimeType;
	}

	public void setMimeType(final String mimeType) {
		this.mimeType = mimeType;
	}

	@Override
	public String toString() {
		return "Attachment [id="
				+ this.id
				+ ", url="
				+ this.url
				+ ", name="
				+ this.name
				+ ", mimeType="
				+ this.mimeType
				+ "]";
	}

}
