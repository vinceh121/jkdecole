package me.vinceh121.jkdecole.messages;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommunicationPreview {
	private Participant currentAuthor, initialAuthor;
	private boolean signalable, isInitialAuthor, attachments, read;
	private long id;
	private Date lastMessage;
	private String subject, state, preview, answerMode;

	@JsonProperty("expediteurActuel")
	public Participant getCurrentAuthor() {
		return this.currentAuthor;
	}

	@JsonProperty("expediteurActuel")
	public void setCurrentAuthor(final Participant currentAuthor) {
		this.currentAuthor = currentAuthor;
	}

	@JsonProperty("expediteurInitial")
	public Participant getInitialAuthor() {
		return this.initialAuthor;
	}

	@JsonProperty("expediteurInitial")
	public void setInitialAuthor(final Participant firstAuthor) {
		this.initialAuthor = firstAuthor;
	}

	public boolean isSignalable() {
		return this.signalable;
	}

	public void setSignalable(final boolean signalable) {
		this.signalable = signalable;
	}

	@JsonProperty("isExpediteurInitial")
	public boolean isInitialAuthor() {
		return this.isInitialAuthor;
	}

	@JsonProperty("isExpediteurInitial")
	public void setInitialAuthor(final boolean isSenderInitial) {
		this.isInitialAuthor = isSenderInitial;
	}

	@JsonProperty("pieceJointe")
	public boolean hasAttachments() {
		return this.attachments;
	}

	@JsonProperty("pieceJointe")
	public void setAttachments(final boolean attachments) {
		this.attachments = attachments;
	}

	@JsonProperty("etatLecture")
	public boolean isRead() {
		return this.read;
	}

	@JsonProperty("etatLecture")
	public void setRead(final boolean read) {
		this.read = read;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@JsonProperty("dateDernierMessage")
	public Date getLastMessage() {
		return this.lastMessage;
	}

	@JsonProperty("dateDernierMessage")
	public void setLastMessage(final Date lastMessage) {
		this.lastMessage = lastMessage;
	}

	@JsonProperty("objet")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("objet")
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@JsonProperty("etat")
	public String getState() {
		return this.state;
	}

	@JsonProperty("etat")
	public void setState(final String state) {
		this.state = state;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return this.preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(final String preview) {
		this.preview = preview;
	}

	@JsonProperty("modeReponse")
	public String getAnswerMode() {
		return this.answerMode;
	}

	@JsonProperty("modeReponse")
	public void setAnswerMode(final String answerMode) {
		this.answerMode = answerMode;
	}

	@Override
	public String toString() {
		return "CommunicationPreview [currentAuthor="
				+ this.currentAuthor
				+ ", firstAuthor="
				+ this.initialAuthor
				+ ", signalable="
				+ this.signalable
				+ ", isSenderInitial="
				+ this.isInitialAuthor
				+ ", attachments="
				+ this.attachments
				+ ", read="
				+ this.read
				+ ", id="
				+ this.id
				+ ", lastMessage="
				+ this.lastMessage
				+ ", subject="
				+ this.subject
				+ ", state="
				+ this.state
				+ ", preview="
				+ this.preview
				+ ", answerMode="
				+ this.answerMode
				+ "]";
	}

}
