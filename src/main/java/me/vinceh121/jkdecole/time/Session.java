package me.vinceh121.jkdecole.time;

import java.util.Date;

import org.json.JSONArray;
import org.json.JSONObject;

public class Session {
	private SessionContent[] todo, due, inSession;
	private boolean actif, edited;
	private Date start, end;
	private int id;
	private String subject, edit, room, title;

	public SessionContent[] getTodo() {
		return this.todo;
	}

	public void setTodo(final SessionContent[] todo) {
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

	public SessionContent[] getInSession() {
		return this.inSession;
	}

	public void setInSession(final SessionContent[] inSession) {
		this.inSession = inSession;
	}

	public SessionContent[] getDue() {
		return this.due;
	}

	public void setDue(final SessionContent[] due) {
		this.due = due;
	}

	public static Session fromJson(final JSONObject obj) {
		final Session session = new Session();
		session.setActif(obj.optBoolean("flagActif"));
		session.setEdited(obj.optBoolean("flagModif"));
		session.setStart(new Date(obj.optLong("hdeb")));
		session.setEnd(new Date(obj.optLong("hend")));
		session.setId(obj.optInt("idSeance"));
		session.setSubject(obj.optString("matiere"));
		session.setEdit(obj.optString("motifModif"));
		session.setRoom(obj.optString("salle"));
		session.setTitle(obj.optString("titre"));

		final JSONArray arrTodo = obj.optJSONArray("aFaire");
		if (arrTodo != null) {
			final SessionContent[] todos = new SessionContent[arrTodo.length()];
			for (int i = 0; i < todos.length; i++)
				todos[i] = SessionContent.fromJson(arrTodo.getJSONObject(i));
			session.setTodo(todos);
		}
		final JSONArray arrDue = obj.optJSONArray("aRendre");
		if (arrDue != null) {
			final SessionContent[] dues = new SessionContent[arrDue.length()];
			for (int i = 0; i < dues.length; i++)
				dues[i] = SessionContent.fromJson(arrDue.getJSONObject(i));
			session.setDue(dues);
		}
		final JSONArray arrInSession = obj.optJSONArray("enSeance");
		if (arrInSession != null) {
			final SessionContent[] inSessions = new SessionContent[arrInSession.length()];
			for (int i = 0; i < inSessions.length; i++)
				inSessions[i] = SessionContent.fromJson(arrInSession.getJSONObject(i));
			session.setInSession(inSessions);
		}

		return session;
	}

}
