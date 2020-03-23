package me.vinceh121.jkdecole.messages;

import org.json.JSONArray;
import org.json.JSONObject;

import me.vinceh121.jkdecole.homework.HWDay;

public class MessageHomework {
	private String errmsg;
	private boolean hwOpen;
	private HWDay[] days;

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	public boolean isHwOpen() {
		return this.hwOpen;
	}

	public void setHwOpen(final boolean hwOpen) {
		this.hwOpen = hwOpen;
	}

	public HWDay[] getDays() {
		return this.days;
	}

	public void setDays(final HWDay[] days) {
		this.days = days;
	}

	public static MessageHomework fromJson(final JSONObject obj) {
		final MessageHomework hw = new MessageHomework();
		hw.setHwOpen(obj.optBoolean("tafOuvert"));
		hw.setErrmsg(obj.optString("errmsg"));

		final JSONArray arrDays = obj.optJSONArray("listeTravaux");
		if (arrDays != null) {
			final HWDay[] days = new HWDay[arrDays.length()];
			for (int i = 0; i < days.length; i++)
				days[i] = HWDay.fromJson(arrDays.getJSONObject(i));
			hw.setDays(days);
		}
		return hw;
	}
}
