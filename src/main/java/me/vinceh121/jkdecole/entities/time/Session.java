package me.vinceh121.jkdecole.entities.time;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Session {
	@JsonProperty("aFaire")
	private List<SessionContent> todo;
	@JsonProperty("aRendre")
	private List<SessionContent> due;
	@JsonProperty("enSeance")
	private List<SessionContent> inSession;
	@JsonProperty("flagActif")
	private boolean actif;
	@JsonProperty("flagModif")
	private boolean edited;
	@JsonProperty("hdeb")
	private Date start;
	@JsonProperty("hend")
	private Date end;
	@JsonProperty("idSeance")
	private int id;
	@JsonProperty("matiere")
	private String subject;
	@JsonProperty("motifModif")
	private String edit;
	@JsonProperty("salle")
	private String room;
	@JsonProperty("titre")
	private String title;

	public List<SessionContent> getTodo() {
		return this.todo;
	}

	public void setTodo(final List<SessionContent> todo) {
		this.todo = todo;
	}

	public boolean isActif() {
		return this.actif;
	}

	public void setActif(final boolean actif) {
		this.actif = actif;
	}

	public boolean isEdited() {
		return this.edited;
	}

	public void setEdited(final boolean edited) {
		this.edited = edited;
	}

	public Date getStart() {
		return this.start;
	}

	public void setStart(final Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return this.end;
	}

	public void setEnd(final Date end) {
		this.end = end;
	}

	public int getId() {
		return this.id;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public String getSubject() {
		return this.subject;
	}

	public void setSubject(final String subject) {
		this.subject = subject;
	}

	public String getEdit() {
		return this.edit;
	}

	public void setEdit(final String edit) {
		this.edit = edit;
	}

	public String getRoom() {
		return this.room;
	}

	public void setRoom(final String room) {
		this.room = room;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(final String title) {
		this.title = title;
	}

	public List<SessionContent> getInSession() {
		return this.inSession;
	}

	public void setInSession(final List<SessionContent> inSession) {
		this.inSession = inSession;
	}

	public List<SessionContent> getDue() {
		return this.due;
	}

	public void setDue(final List<SessionContent> due) {
		this.due = due;
	}
}
