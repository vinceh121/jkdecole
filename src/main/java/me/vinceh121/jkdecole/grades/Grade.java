package me.vinceh121.jkdecole.grades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grade {
	private String id, title, subject, grade;
	private double coef, bareme;
	private Date date;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonProperty("titreDevoir")
	public String getTitle() {
		return title;
	}

	@JsonProperty("titreDevoir")
	public void setTitle(String title) {
		this.title = title;
	}

	@JsonProperty("matiere")
	public String getSubject() {
		return subject;
	}

	@JsonProperty("matiere")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@JsonProperty("note")
	public String getGrade() {
		return grade;
	}

	@JsonProperty("note")
	public void setGrade(String grade) {
		this.grade = grade;
	}

	@JsonProperty("coefficient")
	public double getCoef() {
		return coef;
	}

	@JsonProperty("coefficient")
	public void setCoef(double coef) {
		this.coef = coef;
	}

	@JsonProperty("bareme")
	public double getBareme() {
		return bareme;
	}

	@JsonProperty("bareme")
	public void setBareme(double bareme) {
		this.bareme = bareme;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
