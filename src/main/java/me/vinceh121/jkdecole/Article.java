package me.vinceh121.jkdecole;

import java.util.Date;

import org.json.JSONObject;

public class Article {
	private String author, senderId, errmsg, title, type, uid;
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

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
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

	public static Article fromJson(final JSONObject obj) {
		final Article article = new Article();
		article.setAuthor(obj.optString("auteur"));
		article.setTitle(obj.optString("titre"));
		article.setErrmsg(obj.optString("errmsg"));
		article.setSenderId(obj.optString("senderId"));
		article.setType(obj.optString("type"));
		article.setUid(obj.optString("uid"));
		article.setDate(new Date(obj.optLong("date")));
		return article;
	}

}
