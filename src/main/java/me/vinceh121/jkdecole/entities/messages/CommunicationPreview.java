package me.vinceh121.jkdecole.entities.messages;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommunicationPreview {
	@JsonProperty("expediteurActuel")
	private Participant currentAuthor;
	@JsonProperty("expediteurInitial")
	private Participant initialAuthor;
	private boolean signalable;
	@JsonProperty("isExpediteurInitial")
	private boolean isInitialAuthor;
	@JsonProperty("pieceJointe")
	private boolean attachments;
	@JsonProperty("etatLecture")
	private boolean read;
	private long id;
	@JsonProperty("dateDernierMessage")
	private Date lastMessage;
	@JsonProperty("objet")
	private String subject;
	@JsonProperty("etat")
	private String state;
	@JsonProperty("premieresLignes")
	private String preview;
	@JsonProperty("modeReponse")
	private String answerMode;

	public Participant getCurrentAuthor() {
		return this.currentAuthor;
	}

	public void setCurrentAuthor(final Participant currentAuthor) {
		this.currentAuthor = currentAuthor;
	}

	public Participant getInitialAuthor() {
		return this.initialAuthor;
	}

	public void setInitialAuthor(final Participant firstAuthor) {
		this.initialAuthor = firstAuthor;
	}

	public boolean isSignalable() {
		return this.signalable;
	}

	public void setSignalable(final boolean signalable) {
		this.signalable = signalable;
	}

	public boolean isInitialAuthor() {
		return this.isInitialAuthor;
	}

	public void setInitialAuthor(final boolean isSenderInitial) {
		this.isInitialAuthor = isSenderInitial;
	}

	public boolean hasAttachments() {
		return this.attachments;
	}

	public void setAttachments(final boolean attachments) {
		this.attachments = attachments;
	}

	public boolean isRead() {
		return this.read;
	}

	public void setRead(final boolean read) {
		this.read = read;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	public Date getLastMessage() {
		return this.lastMessage;
	}

	public void setLastMessage(final Date lastMessage) {
		this.lastMessage = lastMessage;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getState() {
		return this.state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getPreview() {
		return this.preview;
	}

	public void setPreview(final String preview) {
		this.preview = preview;
	}

	public String getAnswerMode() {
		return this.answerMode;
	}

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
