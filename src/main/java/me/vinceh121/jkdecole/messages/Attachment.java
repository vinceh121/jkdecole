package me.vinceh121.jkdecole.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Attachment {
	private long id;
	private String url, name, mimeType;

	@JsonProperty("idRessource")
	public long getId() {
		return id;
	}

	@JsonProperty("idRessource")
	public void setId(long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonProperty("idRessource")
	public String getMimeType() {
		return mimeType;
	}

	@JsonProperty("idRessource")
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	@Override
	public String toString() {
		return "Attachment [id=" + id + ", url=" + url + ", name=" + name + ", mimeType=" + mimeType + "]";
	}

}
