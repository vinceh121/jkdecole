package me.vinceh121.jkdecole.time;

import java.util.Date;

import org.json.JSONObject;

public class SessionContent {
	private Date date;
	private String title, type;
	private int uid;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
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

	public int getUid() {
		return this.uid;
	}

	public void setUid(final int uid) {
		this.uid = uid;
	}

	public static SessionContent fromJson(final JSONObject obj) {
		if (obj == null)
			return null;
		final SessionContent cont = new SessionContent();
		cont.setDate(new Date(obj.optLong("date")));
		cont.setTitle(obj.optString("titre"));
		cont.setType(obj.optString("type"));
		cont.setUid(obj.optInt("uid"));
		return cont;
	}
}
