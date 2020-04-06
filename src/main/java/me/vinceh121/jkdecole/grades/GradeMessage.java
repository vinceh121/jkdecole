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
		return gradeModulesEnabled;
	}

	@JsonProperty("moduleNotesActif")
	public void setGradeModulesEnabled(boolean gradeModulesEnabled) {
		this.gradeModulesEnabled = gradeModulesEnabled;
	}

	@JsonProperty("codeEleve")
	public String getStudentCode() {
		return studentCode;
	}

	@JsonProperty("codeEleve")
	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	@JsonProperty("nbNotesMax")
	public int getMaxGrades() {
		return maxGrades;
	}

	@JsonProperty("nbNotesMax")
	public void setMaxGrades(int maxGrades) {
		this.maxGrades = maxGrades;
	}

	@JsonProperty("listeNotes")
	public List<Grade> getGrades() {
		return grades;
	}

	@JsonProperty("listeNotes")
	public void setGrades(List<Grade> grades) {
		this.grades = grades;
	}

}
