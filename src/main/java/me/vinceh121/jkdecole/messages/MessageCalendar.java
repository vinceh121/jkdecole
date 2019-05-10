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
		return calendarOpen;
	}

	public void setCalendarOpen(boolean calendarOpen) {
		this.calendarOpen = calendarOpen;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public TimeTableDay[] getDays() {
		return days;
	}

	public void setDays(TimeTableDay[] days) {
		this.days = days;
	}
	
	public static MessageCalendar fromJson(JSONObject obj) {
		MessageCalendar cal = new MessageCalendar();
		cal.setCalendarOpen(obj.optBoolean("cdtOuvert"));
		cal.setCurrentDate(new Date(obj.optLong("currentDate")));
		cal.setErrmsg(obj.optString("errmsg"));
		
		JSONArray arr = obj.optJSONArray("listeJourCdt");
		if (arr != null) {
			TimeTableDay[] days = new TimeTableDay[arr.length()];
			for (int i = 0; i < arr.length(); i++) {
				days[i] = TimeTableDay.fromJson(arr.getJSONObject(i));
			}
			cal.setDays(days);
		}
		return cal;
	}

}
