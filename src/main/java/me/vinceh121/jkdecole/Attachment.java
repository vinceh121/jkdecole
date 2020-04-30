package me.vinceh121.jkdecole;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
	private long id;
	private String url, name, mimeType;

	@JsonProperty("idRessource")
	public long getId() {
		return this.id;
	}

	@JsonProperty("idRessource")
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

	@JsonProperty("typeMIME")
	public String getMimeType() {
		return this.mimeType;
	}

	@JsonProperty("typeMIME")
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
