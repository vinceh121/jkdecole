package me.vinceh121.jkdecole.entities.time;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SessionContent {
	private Date date;
	private String title, type;
	private int uid;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@JsonProperty("titre")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("titre")
	public void setTitle(final String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public int getUid() {
		return this.uid;
	}

	public void setUid(final int uid) {
		this.uid = uid;
	}
}
