package me.vinceh121.jkdecole.activity;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class ActivityContent {
	private String htmlContent, errmsg, subject, title, type, url;
	private Date date;
	private boolean done, homework, doneEditable;
	private Attachment[] attachments;

	public String getHtmlContent() {
		return this.htmlContent;
	}

	public void setHtmlContent(final String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
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

	public String getUrl() {
		return this.url;
	}

	public void setUrl(final String url) {
		this.url = url;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return this.done;
	}

	public void setDone(final boolean done) {
		this.done = done;
	}

	public boolean isHomework() {
		return this.homework;
	}

	public void setHomework(final boolean homework) {
		this.homework = homework;
	}

	public boolean isDoneEditable() {
		return this.doneEditable;
	}

	public void setDoneEditable(final boolean doneEditable) {
		this.doneEditable = doneEditable;
	}

	public Attachment[] getAttachments() {
		return this.attachments;
	}

	public void setAttachments(final Attachment[] attachments) {
		this.attachments = attachments;
	}

	public static ActivityContent fromJson(final JSONObject obj) {
		final ActivityContent cont = new ActivityContent();
		cont.setHtmlContent(obj.optString("codeHTML"));
		cont.setDate(new Date(obj.optInt("date")));
		cont.setErrmsg(obj.optString("errmsg"));
		cont.setDone(obj.optBoolean("flagRealise"));
		cont.setHomework(obj.optBoolean("flagTravailAFaire"));
		cont.setDoneEditable(obj.optBoolean("isFaitModifiable"));
		cont.setSubject(obj.optString("matiere"));
		cont.setTitle(obj.optString("titre"));
		cont.setType(obj.optString("type"));
		cont.setUrl(obj.optString("url"));

		final JSONArray arr = obj.optJSONArray("pjs");
		final Attachment[] att = new Attachment[arr.length()];
		for (int i = 0; i < arr.length(); i++)
			att[i] = Attachment.fromJson(arr.optJSONObject(i));
		cont.setAttachments(att);

		return cont;
	}

}
