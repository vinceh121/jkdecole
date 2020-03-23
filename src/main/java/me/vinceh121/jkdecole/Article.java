package me.vinceh121.jkdecole;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Article {
	private String author, senderId, errmsg, title, type, uid;
	private Date date;

	@JsonProperty("auteur")
	public String getAuthor() {
		return this.author;
	}

	@JsonProperty("auteur")
	public void setAuthor(final String author) {
		this.author = author;
	}

	public String getSenderId() {
		return this.senderId;
	}

	public void setSenderId(final String senderId) {
		this.senderId = senderId;
	}

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
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
