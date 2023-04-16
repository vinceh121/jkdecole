package me.vinceh121.jkdecole.entities.time;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendar {
	@JsonProperty("cdtOuvert")
	private boolean calendarOpen;
	private Date currentDate;
	@JsonProperty("listeJourCdt")
	private List<TimeTableDay> days;

	public boolean isCalendarOpen() {
		return this.calendarOpen;
	}

	public void setCalendarOpen(final boolean calendarOpen) {
		this.calendarOpen = calendarOpen;
	}

	public Date getCurrentDate() {
		return this.currentDate;
	}

	public void setCurrentDate(final Date currentDate) {
		this.currentDate = currentDate;
	}

	public List<TimeTableDay> getDays() {
		return this.days;
	}

	public void setDays(final List<TimeTableDay> days) {
		this.days = days;
	}
}
