package me.vinceh121.jkdecole;

import java.util.Date;

import org.json.JSONObject;

public class Article {
	private String author, senderId, errmsg, title, type, uid;
	private Date date;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSenderId() {
		return senderId;
	}

	public void setSenderId(String senderId) {
		this.senderId = senderId;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
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

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	public static Article fromJson(JSONObject obj) {
		Article article = new Article();
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
