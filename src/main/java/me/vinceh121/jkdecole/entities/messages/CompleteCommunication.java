package me.vinceh121.jkdecole.entities.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
// TODO parhaps make this extends CommunicationPreview
public class CompleteCommunication {
	@JsonProperty("expediteurActuel")
	private Participant currentAuthor;
	@JsonProperty("expediteurInitial")
	private Participant initialAuthor;
	@JsonProperty("isExpediteurInitial")
	private boolean isInitialAuthor;
	@JsonProperty("pieceJointe")
	private boolean attachments;
	@JsonProperty("etatLecture")
	private boolean read;
	@JsonProperty("signalable")
	private boolean reportable;
	@JsonProperty("objet")
	private String subject;
	private String type;
	@JsonProperty("etat")
	private String state;
	@JsonProperty("modeReponse")
	private String answerMode;
	@JsonProperty("premieresLignes")
	private String preview;
	private List<Participant> participants;
	private List<Participation> participations;
	private long id;
	@JsonProperty("dateDernierMessage")
	private Date dateLastMessage;
	@JsonProperty("nbParticipations")
	private int participationsCount; // i might just remove that

	public Participant getCurrentAuthor() {
		return this.currentAuthor;
	}

	public void setCurrentAuthor(final Participant currentSender) {
		this.currentAuthor = currentSender;
	}

	public Participant getInitialAuthor() {
		return this.initialAuthor;
	}

	public void setInitialAuthor(final Participant initialSender) {
		this.initialAuthor = initialSender;
	}

	public boolean isInitialAuthor() {
		return this.isInitialAuthor;
	}

	public void setInitialAuthor(final boolean isInitialSender) {
		this.isInitialAuthor = isInitialSender;
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

	public boolean isReportable() {
		return this.reportable;
	}

	public void setReportable(final boolean reportable) {
		this.reportable = reportable;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String object) {
		this.subject = object;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getState() {
		return this.state;
	}

	public void setState(final String state) {
		this.state = state;
	}

	public String getAnswerMode() {
		return this.answerMode;
	}

	public void setAnswerMode(final String responseMode) {
		this.answerMode = responseMode;
	}

	public String getPreview() {
		return this.preview;
	}

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

	public Date getDateLastMessage() {
		return this.dateLastMessage;
	}

	public void setDateLastMessage(final Date dateLastMessage) {
		this.dateLastMessage = dateLastMessage;
	}

	public int getParticipationsCount() {
		return this.participationsCount;
	}

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
