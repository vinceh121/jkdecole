package me.vinceh121.jkdecole.entities.homework;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Agenda {
	private boolean hwOpen;
	private List<HWDay> days;

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
