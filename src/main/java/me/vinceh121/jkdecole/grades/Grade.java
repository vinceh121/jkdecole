package me.vinceh121.jkdecole.grades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grade {
	private String id, title, subject, grade;
	private double coef, bareme;
	private Date date;

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	@JsonProperty("titreDevoir")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("titreDevoir")
	public void setTitle(final String title) {
		this.title = title;
	}

	@JsonProperty("matiere")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("matiere")
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@JsonProperty("note")
	public String getGrade() {
		return this.grade;
	}

	@JsonProperty("note")
	public void setGrade(final String grade) {
		this.grade = grade;
	}

	@JsonProperty("coefficient")
	public double getCoef() {
		return this.coef;
	}

	@JsonProperty("coefficient")
	public void setCoef(final double coef) {
		this.coef = coef;
	}

	@JsonProperty("bareme")
	public double getBareme() {
		return this.bareme;
	}

	@JsonProperty("bareme")
	public void setBareme(final double bareme) {
		this.bareme = bareme;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(final Date date) {
		this.date = date;
	}

}
