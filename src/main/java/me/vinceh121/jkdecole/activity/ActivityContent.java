package me.vinceh121.jkdecole.activity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.Attachment;

public class ActivityContent {
	private String htmlContent, errmsg, subject, title, type, url;
	private Date date;
	private boolean done, homework, doneEditable;
	private List<Attachment> attachments;

	@JsonProperty("codeHTML")
	public String getHtmlContent() {
		return this.htmlContent;
	}

	@JsonProperty("codeHTML")
	public void setHtmlContent(final String htmlContent) {
		this.htmlContent = htmlContent;
	}

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	@JsonProperty("matiere")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("matiere")
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@JsonProperty("titre")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("titre")
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

	@JsonProperty("flagRealise")
	public boolean isDone() {
		return this.done;
	}

	@JsonProperty("flagRealise")
	public void setDone(final boolean done) {
		this.done = done;
	}

	@JsonProperty("flagTravailAFaire")
	public boolean isHomework() {
		return this.homework;
	}

	@JsonProperty("flagTravailAFaire")
	public void setHomework(final boolean homework) {
		this.homework = homework;
	}

	@JsonProperty("isFaitModifiable")
	public boolean isDoneEditable() {
		return this.doneEditable;
	}

	@JsonProperty("isFaitModifiable")
	public void setDoneEditable(final boolean doneEditable) {
		this.doneEditable = doneEditable;
	}

	@JsonProperty("pjs")
	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	@JsonProperty("pjs")
	public void setAttachments(final List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
