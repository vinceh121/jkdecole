package me.vinceh121.jkdecole.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participation {
	private long id;
	private Participant author;
	private Date dateSent;
	private String body, preview, label;
	private List<Attachment> attachments;
	private boolean read;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("etatLecture")
	public boolean isRead() {
		return read;
	}

	@JsonProperty("etatLecture")
	public void setRead(boolean read) {
		this.read = read;
	}

	@JsonProperty("redacteur")
	public Participant getAuthor() {
		return author;
	}

	@JsonProperty("redacteur")
	public void setAuthor(Participant author) {
		this.author = author;
	}

	@JsonProperty("dateEnvoi")
	public Date getDateSent() {
		return dateSent;
	}

	@JsonProperty("dateEnvoi")
	public void setDateSent(Date dateSend) {
		this.dateSent = dateSend;
	}

	@JsonProperty("corpsMessage")
	public String getBody() {
		return body;
	}

	@JsonProperty("corpsMessage")
	public void setBody(String body) {
		this.body = body;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(String preview) {
		this.preview = preview;
	}

	@JsonProperty("pjs")
	public List<Attachment> getAttachments() {
		return attachments;
	}

	@JsonProperty("pjs")
	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@JsonProperty("libelleObjet")
	public String getLabel() {
		return label;
	}

	@JsonProperty("libelleObjet")
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Participation [id="
				+ id
				+ ", author="
				+ author
				+ ", dateSent="
				+ dateSent
				+ ", body="
				+ body
				+ ", preview="
				+ preview
				+ ", label="
				+ label
				+ ", attachments="
				+ attachments
				+ ", read="
				+ read
				+ "]";
	}

}
