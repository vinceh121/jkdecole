package me.vinceh121.jkdecole.entities.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participant {
	private String id;
	@JsonProperty("libelle")
	private String label;

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getLabel() {
		return this.label;
	}

	public void setLabel(final String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "ComAuthor [id=" + this.id + ", label=" + this.label + "]";
	}

}
