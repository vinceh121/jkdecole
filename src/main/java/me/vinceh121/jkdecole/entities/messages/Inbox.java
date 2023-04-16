package me.vinceh121.jkdecole.entities.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Inbox {
	@JsonProperty("nbMaxCommunicationRecues")
	private int maxComRecieved;
	@JsonProperty("nbMaxCaracteresMessage")
	private int maxComLength;
	@JsonProperty("nbMaxCommunicationBoiteReception")
	private int maxComInbox;
	@JsonProperty("communications")
	private List<CommunicationPreview> coms;

	public int getMaxComRecieved() {
		return this.maxComRecieved;
	}

	public void setMaxComRecieved(final int maxComRecieved) {
		this.maxComRecieved = maxComRecieved;
	}

	public int getMaxComLength() {
		return this.maxComLength;
	}

	public void setMaxComLength(final int maxComLength) {
		this.maxComLength = maxComLength;
	}

	public int getMaxComInbox() {
		return this.maxComInbox;
	}

	public void setMaxComInbox(final int maxComInbox) {
		this.maxComInbox = maxComInbox;
	}

	public List<CommunicationPreview> getComs() {
		return this.coms;
	}

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
