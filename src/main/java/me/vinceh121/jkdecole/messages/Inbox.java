package me.vinceh121.jkdecole.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inbox {
	private int maxComRecieved, maxComLength, maxComInbox;
	private List<CommunicationPreview> coms;

	@JsonProperty("nbMaxCommunicationRecues")
	public int getMaxComRecieved() {
		return maxComRecieved;
	}

	@JsonProperty("nbMaxCommunicationRecues")
	public void setMaxComRecieved(int maxComRecieved) {
		this.maxComRecieved = maxComRecieved;
	}

	@JsonProperty("nbMaxCaracteresMessage")
	public int getMaxComLength() {
		return maxComLength;
	}

	@JsonProperty("nbMaxCaracteresMessage")
	public void setMaxComLength(int maxComLength) {
		this.maxComLength = maxComLength;
	}

	@JsonProperty("nbMaxCommunicationBoiteReception")
	public int getMaxComInbox() {
		return maxComInbox;
	}

	@JsonProperty("nbMaxCommunicationBoiteReception")
	public void setMaxComInbox(int maxComInbox) {
		this.maxComInbox = maxComInbox;
	}

	@JsonProperty("communications")
	public List<CommunicationPreview> getComs() {
		return coms;
	}

	@JsonProperty("communications")
	public void setComs(List<CommunicationPreview> coms) {
		this.coms = coms;
	}

	@Override
	public String toString() {
		return "Inbox [maxComRecieved="
				+ maxComRecieved
				+ ", maxComLength="
				+ maxComLength
				+ ", maxComInbox="
				+ maxComInbox
				+ ", coms="
				+ coms
				+ "]";
	}
}
