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
		return this.currentAuthor;
	}

	@JsonProperty("expediteurActuel")
	public void setCurrentAuthor(final Participant currentSender) {
		this.currentAuthor = currentSender;
	}

	@JsonProperty("expediteurInitial")
	public Participant getInitialAuthor() {
		return this.initialAuthor;
	}

	@JsonProperty("expediteurInitial")
	public void setInitialAuthor(final Participant initialSender) {
		this.initialAuthor = initialSender;
	}

	@JsonProperty("isExpediteurInitial")
	public boolean isInitialAuthor() {
		return this.isInitialAuthor;
	}

	@JsonProperty("isExpediteurInitial")
	public void setInitialAuthor(final boolean isInitialSender) {
		this.isInitialAuthor = isInitialSender;
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

	@JsonProperty("signalable")
	public boolean isReportable() {
		return this.reportable;
	}

	@JsonProperty("signalable")
	public void setReportable(final boolean reportable) {
		this.reportable = reportable;
	}

	@JsonProperty("objet")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("objet")
	public void setSubject(final String object) {
		this.subject = object;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	@JsonProperty("etat")
	public String getState() {
		return this.state;
	}

	@JsonProperty("etat")
	public void setState(final String state) {
		this.state = state;
	}

	@JsonProperty("modeReponse")
	public String getAnswerMode() {
		return this.answerMode;
	}

	@JsonProperty("modeReponse")
	public void setAnswerMode(final String responseMode) {
		this.answerMode = responseMode;
	}

	@JsonProperty("premieresLignes")
	public String getPreview() {
		return this.preview;
	}

	@JsonProperty("premieresLignes")
	public void setPreview(final String preview) {
		this.preview = preview;
	}

	public List<Participant> getParticipants() {
		return this.participants;
	}

	public void setParticipants(final List<Participant> participants) {
		this.participants = participants;
	}

	public List<Participation> getParticipations() {
		return this.participations;
	}

	public void setParticipations(final List<Participation> participations) {
		this.participations = participations;
	}

	public long getId() {
		return this.id;
	}

	public void setId(final long id) {
		this.id = id;
	}

	@JsonProperty("dateDernierMessage")
	public Date getDateLastMessage() {
		return this.dateLastMessage;
	}

	@JsonProperty("dateDernierMessage")
	public void setDateLastMessage(final Date dateLastMessage) {
		this.dateLastMessage = dateLastMessage;
	}

	@JsonProperty("nbParticipations")
	public int getParticipationsCount() {
		return this.participationsCount;
	}

	@JsonProperty("nbParticipations")
	public void setParticipationsCount(final int participationsCount) {
		this.participationsCount = participationsCount;
	}

	@Override
	public String toString() {
		return "Communication [currentSender="
				+ this.currentAuthor
				+ ", initialSender="
				+ this.initialAuthor
				+ ", isInitialSender="
				+ this.isInitialAuthor
				+ ", attachments="
				+ this.attachments
				+ ", read="
				+ this.read
				+ ", reportable="
				+ this.reportable
				+ ", object="
				+ this.subject
				+ ", type="
				+ this.type
				+ ", state="
				+ this.state
				+ ", responseMode="
				+ this.answerMode
				+ ", preview="
				+ this.preview
				+ ", participants="
				+ this.participants
				+ ", participations="
				+ this.participations
				+ ", id="
				+ this.id
				+ ", dateLastMessage="
				+ this.dateLastMessage
				+ ", participationsCount="
				+ this.participationsCount
				+ "]";
	}

}
