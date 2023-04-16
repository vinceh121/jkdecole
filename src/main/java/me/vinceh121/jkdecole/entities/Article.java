package me.vinceh121.jkdecole.entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
	@JsonProperty("auteur")
	private String author;
	private String senderId;
	@JsonProperty("titre")
	private String title;
	private String type;
	private String uid;
	private Date date;

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(final String senderId) {
		this.senderId = senderId;
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

	public String getUid() {
		return this.uid;
	}

	public void setUid(final String uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}
}
