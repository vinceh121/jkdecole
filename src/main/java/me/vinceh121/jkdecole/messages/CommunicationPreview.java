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
		return currentAuthor;
	}

	@JsonProperty("expediteurActuel")
	public void setCurrentAuthor(Participant currentAuthor) {
		this.currentAuthor = currentAuthor;
	}

	@JsonProperty("expediteurInitial")
	public Participant getInitialAuthor() {
		return initialAuthor;
	}

	@JsonProperty("expediteurInitial")
	public void setInitialAuthor(Participant firstAuthor) {
		this.initialAuthor = firstAuthor;
	}

	public boolean isSignalable() {
		return signalable;
	}

	public void setSignalable(boolean signalable) {
		this.signalable = signalable;
	}

	@JsonProperty("isExpediteurInitial")
	public boolean isInitialAuthor() {
		return isInitialAuthor;
	}

	@JsonProperty("isExpediteurInitial")
	public void setInitialAuthor(boolean isSenderInitial) {
		this.isInitialAuthor = isSenderInitial;
	}

	@JsonProperty("pieceJointe")
	public boolean hasAttachments() {
		return attachments;
	}

	@JsonProperty("pieceJointe")
	public void setAttachments(boolean attachments) {
		this.attachments = attachments;
	}

	@JsonProperty("etatLecture")
	public boolean isRead() {
		return read;
	}

	@JsonProperty("etatLecture")
	public void setRead(boolean read) {
		this.read = read;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("dateDernierMessage")
	public Date getLastMessage() {
		return lastMessage;
	}

	@JsonProperty("dateDernierMessage")
	public void setLastMessage(Date lastMessage) {
		this.lastMessage = lastMessage;
	}

	@JsonProperty("objet")
	public String getSubject() {
		return subject;
	}

	@JsonProperty("objet")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonProperty("etat")
	public String getState() {
		return state;
	}

	@JsonProperty("etat")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(String preview) {
		this.preview = preview;
	}

	@JsonProperty("modeReponse")
	public String getAnswerMode() {
		return answerMode;
	}

	@JsonProperty("modeReponse")
	public void setAnswerMode(String answerMode) {
		this.answerMode = answerMode;
	}

	@Override
	public String toString() {
		return "CommunicationPreview [currentAuthor="
				+ currentAuthor
				+ ", firstAuthor="
				+ initialAuthor
				+ ", signalable="
				+ signalable
				+ ", isSenderInitial="
				+ isInitialAuthor
				+ ", attachments="
				+ attachments
				+ ", read="
				+ read
				+ ", id="
				+ id
				+ ", lastMessage="
				+ lastMessage
				+ ", subject="
				+ subject
				+ ", state="
				+ state
				+ ", preview="
				+ preview
				+ ", answerMode="
				+ answerMode
				+ "]";
	}

}
