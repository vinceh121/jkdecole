package me.vinceh121.jkdecole.entities.homework;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Homework {
	@JsonProperty("date")
	private Date givenAt;
	@JsonProperty("flagRealise")
	private boolean done;
	@JsonProperty("temps")
	private int time;
	@JsonProperty("matiere")
	private String subject;
	@JsonProperty("titre")
	private String title;
	private String type;
	private String uid;
	@JsonProperty("uidSeance")
	private String sessionId;

	public Date getGivenAt() {
		return this.givenAt;
	}

	public void setGivenAt(final Date givenAt) {
		this.givenAt = givenAt;
	}

	public boolean isDone() {
		return this.done;
	}

	public void setDone(final boolean done) {
		this.done = done;
	}

	public int getTime() {
		return this.time;
	}

	public void setTime(final int time) {
		this.time = time;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

	public String getUid() {
		return this.uid;
	}

	public void setUid(final String uid) {
		this.uid = uid;
	}

	public String getSessionId() {
		return this.sessionId;
	}

	public void setSessionId(final String sessionId) {
		this.sessionId = sessionId;
	}
}
