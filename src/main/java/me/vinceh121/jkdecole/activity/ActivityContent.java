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
		return htmlContent;
	}

	public void setHtmlContent(String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
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

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	public boolean isHomework() {
		return homework;
	}

	public void setHomework(boolean homework) {
		this.homework = homework;
	}

	public boolean isDoneEditable() {
		return doneEditable;
	}

	public void setDoneEditable(boolean doneEditable) {
		this.doneEditable = doneEditable;
	}

	public Attachment[] getAttachments() {
		return attachments;
	}

	public void setAttachments(Attachment[] attachments) {
		this.attachments = attachments;
	}

	public static ActivityContent fromJson(JSONObject obj) {
		ActivityContent cont = new ActivityContent();
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
		
		JSONArray arr = obj.optJSONArray("pjs");
		Attachment[] att = new Attachment[arr.length()];
		for (int i = 0; i < arr.length(); i++) {
			att[i] = Attachment.fromJson(arr.optJSONObject(i));
		}
		cont.setAttachments(att);
		
		return cont;
	}

}
