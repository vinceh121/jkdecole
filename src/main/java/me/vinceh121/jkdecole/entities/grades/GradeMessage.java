package me.vinceh121.jkdecole.entities.grades;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class GradeMessage {
	@JsonProperty("moduleNotesActif")
	private boolean gradeModulesEnabled;
	@JsonProperty("codeEleve")
	private String studentCode;
	@JsonProperty("nbNotesMax")
	private int maxGrades;
	@JsonProperty("listeNotes")
	private List<Grade> grades;

	public boolean isGradeModulesEnabled() {
		return this.gradeModulesEnabled;
	}

	public void setGradeModulesEnabled(final boolean gradeModulesEnabled) {
		this.gradeModulesEnabled = gradeModulesEnabled;
	}

	public String getStudentCode() {
		return this.studentCode;
	}

	public void setStudentCode(final String studentCode) {
		this.studentCode = studentCode;
	}

	public int getMaxGrades() {
		return this.maxGrades;
	}

	public void setMaxGrades(final int maxGrades) {
		this.maxGrades = maxGrades;
	}

	public List<Grade> getGrades() {
		return this.grades;
	}

	public void setGrades(final List<Grade> grades) {
		this.grades = grades;
	}
}
