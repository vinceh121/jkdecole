package me.vinceh121.jkdecole.messages;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.time.TimeTableDay;

public class MessageCalendar {
	private boolean calendarOpen;
	private Date currentDate;
	private String errmsg;
	private List<TimeTableDay> days;

	@JsonProperty("cdtOuvert")
	public boolean isCalendarOpen() {
		return this.calendarOpen;
	}

	@JsonProperty("cdtOuvert")
	public void setCalendarOpen(final boolean calendarOpen) {
		this.calendarOpen = calendarOpen;
	}

	public Date getCurrentDate() {
		return this.currentDate;
	}

	public void setCurrentDate(final Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	@JsonProperty("listeJourCdt")
	public List<TimeTableDay> getDays() {
		return this.days;
	}

	@JsonProperty("listeJourCdt")
	public void setDays(final List<TimeTableDay> days) {
		this.days = days;
	}

}
