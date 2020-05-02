package me.vinceh121.jkdecole.entities.time;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TimeTableDay {
	private Date date;
	private List<Session> sessions;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	@JsonProperty("listeSeances")
	public List<Session> getSessions() {
		return this.sessions;
	}

	@JsonProperty("listeSeances")
	public void setSessions(final List<Session> sessions) {
		this.sessions = sessions;
	}
}
