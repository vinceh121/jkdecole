package me.vinceh121.jkdecole.entities.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.entities.Attachment;

public class Participation {
	private long id;
	private Participant author;
	private Date dateSent;
	private String body, preview, label;
	private List<Attachment> attachments;
	private boolean read;

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@JsonProperty("etatLecture")
	public boolean isRead() {
		return this.read;
	}

	@JsonProperty("etatLecture")
	public void setRead(final boolean read) {
		this.read = read;
	}

	@JsonProperty("redacteur")
	public Participant getAuthor() {
		return this.author;
	}

	@JsonProperty("redacteur")
	public void setAuthor(final Participant author) {
		this.author = author;
	}

	@JsonProperty("dateEnvoi")
	public Date getDateSent() {
		return this.dateSent;
	}

	@JsonProperty("dateEnvoi")
	public void setDateSent(final Date dateSend) {
		this.dateSent = dateSend;
	}

	@JsonProperty("corpsMessage")
	public String getBody() {
		return this.body;
	}

	@JsonProperty("corpsMessage")
	public void setBody(final String body) {
		this.body = body;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return this.preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(final String preview) {
		this.preview = preview;
	}

	@JsonProperty("pjs")
	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	@JsonProperty("pjs")
	public void setAttachments(final List<Attachment> attachments) {
		this.attachments = attachments;
	}

	@JsonProperty("libelleObjet")
	public String getLabel() {
		return this.label;
	}

	@JsonProperty("libelleObjet")
	public void setLabel(final String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "Participation [id="
				+ this.id
				+ ", author="
				+ this.author
				+ ", dateSent="
				+ this.dateSent
				+ ", body="
				+ this.body
				+ ", preview="
				+ this.preview
				+ ", label="
				+ this.label
				+ ", attachments="
				+ this.attachments
				+ ", read="
				+ this.read
				+ "]";
	}

}
