package me.vinceh121.jkdecole.messages;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

import me.vinceh121.jkdecole.time.TimeTableDay;

public class MessageCalendar {
	private boolean calendarOpen;
	private Date currentDate;
	private String errmsg;
	private TimeTableDay[] days;

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

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	public TimeTableDay[] getDays() {
		return this.days;
	}

	public void setDays(final TimeTableDay[] days) {
		this.days = days;
	}

	public static MessageCalendar fromJson(final JSONObject obj) {
		final MessageCalendar cal = new MessageCalendar();
		cal.setCalendarOpen(obj.optBoolean("cdtOuvert"));
		cal.setCurrentDate(new Date(obj.optLong("currentDate")));
		cal.setErrmsg(obj.optString("errmsg"));

		final JSONArray arr = obj.optJSONArray("listeJourCdt");
		if (arr != null) {
			final TimeTableDay[] days = new TimeTableDay[arr.length()];
			for (int i = 0; i < arr.length(); i++)
				days[i] = TimeTableDay.fromJson(arr.getJSONObject(i));
			cal.setDays(days);
		}
		return cal;
	}

}
