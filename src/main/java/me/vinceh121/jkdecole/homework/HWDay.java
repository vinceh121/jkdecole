package me.vinceh121.jkdecole.homework;

import java.util.Date;

import org.json.JSONObject;

public class HWDay {
	private Date date;

	private Homework[] homeworks;

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public Homework[] getHomeworks() {
		return this.homeworks;
	}

	public void setHomeworks(final Homework[] homeworks) {
		this.homeworks = homeworks;
	}

	public static HWDay fromJson(final JSONObject obj) {

		return null;
	}
}
