package me.vinceh121.jkdecole.time;

import java.util.Date;

import org.json.JSONObject;

public class SessionContent {
	private Date date;
	private String title, type;
	private int uid;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public static SessionContent fromJson(JSONObject obj) {
		if (obj == null)
			return null;
		SessionContent cont = new SessionContent();
		cont.setDate(new Date(obj.optLong("date")));
		cont.setTitle(obj.optString("titre"));
		cont.setType(obj.optString("type"));
		cont.setUid(obj.optInt("uid"));
		return cont;
	}
}
