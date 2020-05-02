package me.vinceh121.jkdecole.entities.time;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Calendar {
	private boolean calendarOpen;
	private Date currentDate;
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

	@JsonProperty("listeJourCdt")
	public List<TimeTableDay> getDays() {
		return this.days;
	}

	@JsonProperty("listeJourCdt")
	public void setDays(final List<TimeTableDay> days) {
		this.days = days;
	}

}
