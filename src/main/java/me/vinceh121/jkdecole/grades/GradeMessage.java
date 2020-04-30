package me.vinceh121.jkdecole.grades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradeMessage {
	private boolean gradeModulesEnabled;
	private String studentCode;
	private int maxGrades;
	private List<Grade> grades;

	@JsonProperty("moduleNotesActif")
	public boolean isGradeModulesEnabled() {
		return this.gradeModulesEnabled;
	}

	@JsonProperty("moduleNotesActif")
	public void setGradeModulesEnabled(final boolean gradeModulesEnabled) {
		this.gradeModulesEnabled = gradeModulesEnabled;
	}

	@JsonProperty("codeEleve")
	public String getStudentCode() {
		return this.studentCode;
	}

	@JsonProperty("codeEleve")
	public void setStudentCode(final String studentCode) {
		this.studentCode = studentCode;
	}

	@JsonProperty("nbNotesMax")
	public int getMaxGrades() {
		return this.maxGrades;
	}

	@JsonProperty("nbNotesMax")
	public void setMaxGrades(final int maxGrades) {
		this.maxGrades = maxGrades;
	}

	@JsonProperty("listeNotes")
	public List<Grade> getGrades() {
		return this.grades;
	}

	@JsonProperty("listeNotes")
	public void setGrades(final List<Grade> grades) {
		this.grades = grades;
	}

}
