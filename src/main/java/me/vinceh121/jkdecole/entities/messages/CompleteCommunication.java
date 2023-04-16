package me.vinceh121.jkdecole.entities.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CompleteCommunication extends CommunicationPreview {
	private String type;
	@JsonProperty("modeReponse")
	private String answerMode;
	private List<Participant> participants;
	private List<Participation> participations;
	@JsonProperty("nbParticipations")
	private int participationsCount; // i might just remove that

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAnswerMode() {
		return answerMode;
	}

	public void setAnswerMode(String answerMode) {
		this.answerMode = answerMode;
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

	public int getParticipationsCount() {
		return participationsCount;
	}

	public void setParticipationsCount(int participationsCount) {
		this.participationsCount = participationsCount;
	}

	@Override
	public String toString() {
		return "CompleteCommunication [getType()="
				+ getType()
				+ ", getAnswerMode()="
				+ getAnswerMode()
				+ ", getParticipants()="
				+ getParticipants()
				+ ", getParticipations()="
				+ getParticipations()
				+ ", getParticipationsCount()="
				+ getParticipationsCount()
				+ ", getCurrentAuthor()="
				+ getCurrentAuthor()
				+ ", getInitialAuthor()="
				+ getInitialAuthor()
				+ ", isSignalable()="
				+ isSignalable()
				+ ", isInitialAuthor()="
				+ isInitialAuthor()
				+ ", hasAttachments()="
				+ hasAttachments()
				+ ", isRead()="
				+ isRead()
				+ ", getId()="
				+ getId()
				+ ", getLastMessage()="
				+ getLastMessage()
				+ ", getSubject()="
				+ getSubject()
				+ ", getState()="
				+ getState()
				+ ", getPreview()="
				+ getPreview()
				+ "]";
	}
}
