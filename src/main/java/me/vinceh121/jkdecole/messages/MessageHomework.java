package me.vinceh121.jkdecole.messages;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.homework.HWDay;

public class MessageHomework {
	private String errmsg;
	private boolean hwOpen;
	private List<HWDay> days;

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	@JsonProperty("tafOuvert")
	public boolean isHwOpen() {
		return this.hwOpen;
	}

	@JsonProperty("tafOuvert")
	public void setHwOpen(final boolean hwOpen) {
		this.hwOpen = hwOpen;
	}

	@JsonProperty("listeTravaux")
	public List<HWDay> getDays() {
		return this.days;
	}

	@JsonProperty("listeTravaux")
	public void setDays(final List<HWDay> days) {
		this.days = days;
	}
}
