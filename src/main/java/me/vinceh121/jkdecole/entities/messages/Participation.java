package me.vinceh121.jkdecole.entities.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.entities.Attachment;

public class Participation {
	private long id;
	@JsonProperty("redacteur")
	private Participant author;
	@JsonProperty("dateEnvoi")
	private Date dateSent;
	@JsonProperty("corpsMessage")
	private String body;
	@JsonProperty("premieresLignes")
	private String preview;
	@JsonProperty("libelleObjet")
	private String label;
	@JsonProperty("pjs")
	private List<Attachment> attachments;
	@JsonProperty("etatLecture")
	private boolean read;

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public boolean isRead() {
		return this.read;
	}

	public void setRead(final boolean read) {
		this.read = read;
	}

	public Participant getAuthor() {
		return this.author;
	}

	public void setAuthor(final Participant author) {
		this.author = author;
	}

	public Date getDateSent() {
		return this.dateSent;
	}

	public void setDateSent(final Date dateSend) {
		this.dateSent = dateSend;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(final String body) {
		this.body = body;
	}

	public String getPreview() {
		return this.preview;
	}

	public void setPreview(final String preview) {
		this.preview = preview;
	}

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(final List<Attachment> attachments) {
		this.attachments = attachments;
	}

	public String getLabel() {
		return this.label;
	}

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
