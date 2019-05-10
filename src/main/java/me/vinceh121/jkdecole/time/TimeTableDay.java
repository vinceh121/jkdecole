package me.vinceh121.jkdecole.time;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class TimeTableDay {
	private Date date;
	private Session[] sessions;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Session[] getSessions() {
		return sessions;
	}

	public void setSessions(Session[] sessions) {
		this.sessions = sessions;
	}

	public static TimeTableDay fromJson(JSONObject jsonObject) {
		TimeTableDay day = new TimeTableDay();
		day.setDate(new Date(jsonObject.optLong("date")));
		JSONArray arr = jsonObject.optJSONArray("listeSeances");
		if (arr != null) {
			Session[] sessions = new Session[arr.length()];
			for (int i = 0; i < arr.length(); i++) {
				sessions[i] = Session.fromJson(arr.getJSONObject(i));
			}
			day.setSessions(sessions);
		}
		return day;
	}
}
