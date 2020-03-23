package me.vinceh121.jkdecole.time;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class TimeTableDay {
	private Date date;
	private Session[] sessions;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Session[] getSessions() {
		return this.sessions;
	}

	public void setSessions(final Session[] sessions) {
		this.sessions = sessions;
	}

	public static TimeTableDay fromJson(final JSONObject jsonObject) {
		final TimeTableDay day = new TimeTableDay();
		day.setDate(new Date(jsonObject.optLong("date")));
		final JSONArray arr = jsonObject.optJSONArray("listeSeances");
		if (arr != null) {
			final Session[] sessions = new Session[arr.length()];
			for (int i = 0; i < arr.length(); i++)
				sessions[i] = Session.fromJson(arr.getJSONObject(i));
			day.setSessions(sessions);
		}
		return day;
	}
}
