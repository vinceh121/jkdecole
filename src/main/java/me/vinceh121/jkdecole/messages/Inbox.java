package me.vinceh121.jkdecole.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inbox {
	private int maxComRecieved, maxComLength, maxComInbox;
	private List<CommunicationPreview> coms;

	@JsonProperty("nbMaxCommunicationRecues")
	public int getMaxComRecieved() {
		return this.maxComRecieved;
	}

	@JsonProperty("nbMaxCommunicationRecues")
	public void setMaxComRecieved(final int maxComRecieved) {
		this.maxComRecieved = maxComRecieved;
	}

	@JsonProperty("nbMaxCaracteresMessage")
	public int getMaxComLength() {
		return this.maxComLength;
	}

	@JsonProperty("nbMaxCaracteresMessage")
	public void setMaxComLength(final int maxComLength) {
		this.maxComLength = maxComLength;
	}

	@JsonProperty("nbMaxCommunicationBoiteReception")
	public int getMaxComInbox() {
		return this.maxComInbox;
	}

	@JsonProperty("nbMaxCommunicationBoiteReception")
	public void setMaxComInbox(final int maxComInbox) {
		this.maxComInbox = maxComInbox;
	}

	@JsonProperty("communications")
	public List<CommunicationPreview> getComs() {
		return this.coms;
	}

	@JsonProperty("communications")
	public void setComs(final List<CommunicationPreview> coms) {
		this.coms = coms;
	}

	@Override
	public String toString() {
		return "Inbox [maxComRecieved="
				+ this.maxComRecieved
				+ ", maxComLength="
				+ this.maxComLength
				+ ", maxComInbox="
				+ this.maxComInbox
				+ ", coms="
				+ this.coms
				+ "]";
	}
}
