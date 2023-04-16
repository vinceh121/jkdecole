package me.vinceh121.jkdecole.entities.activity;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import me.vinceh121.jkdecole.entities.Attachment;

public class ActivityContent {
	@JsonProperty("codeHTML")
	private String htmlContent;
	@JsonProperty("matiere")
	private String subject;
	@JsonProperty("titre")
	private String title;
	private String type;
	private String url;
	private Date date;
	@JsonProperty("flagRealise")
	private boolean done;
	@JsonProperty("flagTravailAFaire")
	private boolean homework;
	@JsonProperty("isFaitModifiable")
	private boolean doneEditable;
	@JsonProperty("pjs")
	private List<Attachment> attachments;

	public String getHtmlContent() {
		return this.htmlContent;
	}

	public void setHtmlContent(final String htmlContent) {
		this.htmlContent = htmlContent;
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

	public List<Attachment> getAttachments() {
		return this.attachments;
	}

	public void setAttachments(final List<Attachment> attachments) {
		this.attachments = attachments;
	}
}
