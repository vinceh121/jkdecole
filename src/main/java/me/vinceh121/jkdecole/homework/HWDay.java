package me.vinceh121.jkdecole.homework;

import java.util.Date;

import org.json.JSONObject;

public class HWDay {
	private Date date;

	private Homework[] homeworks;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Homework[] getHomeworks() {
		return homeworks;
	}

	public void setHomeworks(Homework[] homeworks) {
		this.homeworks = homeworks;
	}

	public static HWDay fromJson(JSONObject obj) {

		return null;
	}
}
