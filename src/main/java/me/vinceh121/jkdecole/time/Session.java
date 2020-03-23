package me.vinceh121.jkdecole.time;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {
	private List<SessionContent> todo, due, inSession;
	private boolean actif, edited;
	private Date start, end;
	private int id;
	private String subject, edit, room, title;

	@JsonProperty("aFaire")
	public List<SessionContent> getTodo() {
		return this.todo;
	}

	@JsonProperty("aFaire")
	public void setTodo(final List<SessionContent> todo) {
		this.todo = todo;
	}

	@JsonProperty("flagActif")
	public boolean isActif() {
		return this.actif;
	}

	@JsonProperty("flagActif")
	public void setActif(final boolean actif) {
		this.actif = actif;
	}

	@JsonProperty("flagModif")
	public boolean isEdited() {
		return this.edited;
	}

	@JsonProperty("flagModif")
	public void setEdited(final boolean edited) {
		this.edited = edited;
	}

	@JsonProperty("hdeb")
	public Date getStart() {
		return this.start;
	}

	@JsonProperty("hdeb")
	public void setStart(final Date start) {
		this.start = start;
	}

	@JsonProperty("hend")
	public Date getEnd() {
		return this.end;
	}

	@JsonProperty("hend")
	public void setEnd(final Date end) {
		this.end = end;
	}

	@JsonProperty("idSeance")
	public int getId() {
		return this.id;
	}

	@JsonProperty("idSeance")
	public void setId(final int id) {
		this.id = id;
	}

	@JsonProperty("matiere")
	public String getSubject() {
		return this.subject;
	}

	@JsonProperty("matiere")
	public void setSubject(final String subject) {
		this.subject = subject;
	}

	@JsonProperty("motifModif")
	public String getEdit() {
		return this.edit;
	}

	@JsonProperty("motifModif")
	public void setEdit(final String edit) {
		this.edit = edit;
	}

	@JsonProperty("salle")
	public String getRoom() {
		return this.room;
	}

	@JsonProperty("salle")
	public void setRoom(final String room) {
		this.room = room;
	}

	@JsonProperty("titre")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("titre")
	public void setTitle(final String title) {
		this.title = title;
	}

	@JsonProperty("enSeance")
	public List<SessionContent> getInSession() {
		return this.inSession;
	}

	@JsonProperty("enSeance")
	public void setInSession(final List<SessionContent> inSession) {
		this.inSession = inSession;
	}

	@JsonProperty("aRendre")
	public List<SessionContent> getDue() {
		return this.due;
	}

	@JsonProperty("aRendre")
	public void setDue(final List<SessionContent> due) {
		this.due = due;
	}
}
