package me.vinceh121.jkdecole.entities.homework;

import java.util.Date;

public class HWDay { // TODO json serialization
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

}
