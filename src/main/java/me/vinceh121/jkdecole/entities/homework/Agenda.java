package me.vinceh121.jkdecole.entities.homework;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agenda {
	@JsonProperty("tafOuvert")
	private boolean hwOpen;
	@JsonProperty("listeTravaux")
	private List<HWDay> days;

	public boolean isHwOpen() {
		return this.hwOpen;
	}

	public void setHwOpen(final boolean hwOpen) {
		this.hwOpen = hwOpen;
	}

	public List<HWDay> getDays() {
		return this.days;
	}

	public void setDays(final List<HWDay> days) {
		this.days = days;
	}
}
