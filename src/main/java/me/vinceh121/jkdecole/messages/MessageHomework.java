package me.vinceh121.jkdecole.messages;

import org.json.JSONArray;
import org.json.JSONObject;

import me.vinceh121.jkdecole.homework.HWDay;

public class MessageHomework {
	private String errmsg;
	private boolean hwOpen;
	private HWDay[] days;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public boolean isHwOpen() {
		return hwOpen;
	}

	public void setHwOpen(boolean hwOpen) {
		this.hwOpen = hwOpen;
	}

	public HWDay[] getDays() {
		return days;
	}

	public void setDays(HWDay[] days) {
		this.days = days;
	}

	public static MessageHomework fromJson(JSONObject obj) {
		MessageHomework hw = new MessageHomework();
		hw.setHwOpen(obj.optBoolean("tafOuvert"));
		hw.setErrmsg(obj.optString("errmsg"));

		JSONArray arrDays = obj.optJSONArray("listeTravaux");
		if (arrDays != null) {
			HWDay[] days = new HWDay[arrDays.length()];
			for (int i = 0; i < days.length; i++) {
				days[i] = HWDay.fromJson(arrDays.getJSONObject(i));
			}
			hw.setDays(days);
		}
		return hw;
	}
}
