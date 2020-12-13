package me.vinceh121.jkdecole.entities.homework;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class Homework {

	private Date givenAt;
	private boolean done;
	private int time;
	private String subject, title, type, uid, sessionId;

	@JsonProperty("date")
	public Date getGivenAt() {
		return this.givenAt;
	}

	@JsonProperty("date")
	public void setGivenAt(final Date givenAt) {
		this.givenAt = givenAt;
	}

	@JsonProperty("flagRealise")
	public boolean isDone() {
		return this.done;
	}

	@JsonProperty("flagRealise")
	public void setDone(final boolean done) {
		this.done = done;
	}

	@JsonProperty("temps")
	public int getTime() {
		return this.time;
	}

	@JsonProperty("temps")
	public void setTime(final int time) {
		this.time = time;
	}

	@JsonProperty("matiere")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("matiere")
	public void setSubject(final String subject) {
		this.subject = subject;
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

	public String getUid() {
		return this.uid;
	}

	public void setUid(final String uid) {
		this.uid = uid;
	}

	@JsonProperty("uidSeance")
	public String getSessionId() {
		return this.sessionId;
	}

	@JsonProperty("uidSeance")
	public void setSessionId(final String sessionId) {
		this.sessionId = sessionId;
	}

}
