package me.vinceh121.jkdecole.messages;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Participant {
	private String id, label;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("libelle")
	public String getLabel() {
		return label;
	}

	@JsonProperty("libelle")
	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return "ComAuthor [id=" + id + ", label=" + label + "]";
	}

}
