package me.vinceh121.jkdecole.entities.grades;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Grade {
	private String id;
	@JsonProperty("titreDevoir")
	private String title;
	@JsonProperty("matiere")
	private String subject;
	@JsonProperty("note")
	private String grade;
	@JsonProperty("coefficient")
	private double coef;
	@JsonProperty("bareme")
	private double bareme;
	private Date date;

	public String getId() {
		return this.id;
	}

	public void setId(final String id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getGrade() {
		return this.grade;
	}

	public void setGrade(final String grade) {
		this.grade = grade;
	}

	public double getCoef() {
		return this.coef;
	}

	public void setCoef(final double coef) {
		this.coef = coef;
	}

	public double getBareme() {
		return this.bareme;
	}

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
