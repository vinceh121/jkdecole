package me.vinceh121.jkdecole.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteCommunication {
	private Participant currentAuthor, initialAuthor;
	private boolean isInitialAuthor, attachments, read, reportable;
	private String subject, type, state, answerMode, preview;
	private List<Participant> participants;
	private List<Participation> participations;
	private long id;
	private Date dateLastMessage;
	private int participationsCount; // i might just remove that

	@JsonProperty("expediteurActuel")
	public Participant getCurrentAuthor() {
		return currentAuthor;
	}

	@JsonProperty("expediteurActuel")
	public void setCurrentAuthor(Participant currentSender) {
		this.currentAuthor = currentSender;
	}

	@JsonProperty("expediteurInitial")
	public Participant getInitialAuthor() {
		return initialAuthor;
	}

	@JsonProperty("expediteurInitial")
	public void setInitialAuthor(Participant initialSender) {
		this.initialAuthor = initialSender;
	}

	@JsonProperty("isExpediteurInitial")
	public boolean isInitialAuthor() {
		return isInitialAuthor;
	}

	@JsonProperty("isExpediteurInitial")
	public void setInitialAuthor(boolean isInitialSender) {
		this.isInitialAuthor = isInitialSender;
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

	@JsonProperty("signalable")
	public boolean isReportable() {
		return reportable;
	}

	@JsonProperty("signalable")
	public void setReportable(boolean reportable) {
		this.reportable = reportable;
	}

	@JsonProperty("objet")
	public String getSubject() {
		return subject;
	}

	@JsonProperty("objet")
	public void setSubject(String object) {
		this.subject = object;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@JsonProperty("etat")
	public String getState() {
		return state;
	}

	@JsonProperty("etat")
	public void setState(String state) {
		this.state = state;
	}

	@JsonProperty("modeReponse")
	public String getAnswerMode() {
		return answerMode;
	}

	@JsonProperty("modeReponse")
	public void setAnswerMode(String responseMode) {
		this.answerMode = responseMode;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(String preview) {
		this.preview = preview;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public List<Participation> getParticipations() {
		return participations;
	}

	public void setParticipations(List<Participation> participations) {
		this.participations = participations;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty("dateDernierMessage")
	public Date getDateLastMessage() {
		return dateLastMessage;
	}

	@JsonProperty("dateDernierMessage")
	public void setDateLastMessage(Date dateLastMessage) {
		this.dateLastMessage = dateLastMessage;
	}

	@JsonProperty("nbParticipations")
	public int getParticipationsCount() {
		return participationsCount;
	}

	@JsonProperty("nbParticipations")
	public void setParticipationsCount(int participationsCount) {
		this.participationsCount = participationsCount;
	}

	@Override
	public String toString() {
		return "Communication [currentSender="
				+ currentAuthor
				+ ", initialSender="
				+ initialAuthor
				+ ", isInitialSender="
				+ isInitialAuthor
				+ ", attachments="
				+ attachments
				+ ", read="
				+ read
				+ ", reportable="
				+ reportable
				+ ", object="
				+ subject
				+ ", type="
				+ type
				+ ", state="
				+ state
				+ ", responseMode="
				+ answerMode
				+ ", preview="
				+ preview
				+ ", participants="
				+ participants
				+ ", participations="
				+ participations
				+ ", id="
				+ id
				+ ", dateLastMessage="
				+ dateLastMessage
				+ ", participationsCount="
				+ participationsCount
				+ "]";
	}

}
