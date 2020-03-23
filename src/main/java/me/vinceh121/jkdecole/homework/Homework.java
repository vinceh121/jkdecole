package me.vinceh121.jkdecole.homework;

import java.util.Date;

public class Homework {
	private Date date;
	private boolean done;
	private int time;
	private String subject, title, type, uid, sessionId;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
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
