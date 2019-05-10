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
		return todo;
	}

	public void setTodo(SessionContent[] todo) {
		this.todo = todo;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public boolean isEdited() {
		return edited;
	}

	public void setEdited(boolean edited) {
		this.edited = edited;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getEdit() {
		return edit;
	}

	public void setEdit(String edit) {
		this.edit = edit;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public SessionContent[] getInSession() {
		return inSession;
	}

	public void setInSession(SessionContent[] inSession) {
		this.inSession = inSession;
	}

	public SessionContent[] getDue() {
		return due;
	}

	public void setDue(SessionContent[] due) {
		this.due = due;
	}

	public static Session fromJson(JSONObject obj) {
		Session session = new Session();
		session.setActif(obj.optBoolean("flagActif"));
		session.setEdited(obj.optBoolean("flagModif"));
		session.setStart(new Date(obj.optLong("hdeb")));
		session.setEnd(new Date(obj.optLong("hend")));
		session.setId(obj.optInt("idSeance"));
		session.setSubject(obj.optString("matiere"));
		session.setEdit(obj.optString("motifModif"));
		session.setRoom(obj.optString("salle"));
		session.setTitle(obj.optString("titre"));

		JSONArray arrTodo = obj.optJSONArray("aFaire");
		if (arrTodo != null) {
			SessionContent[] todos = new SessionContent[arrTodo.length()];
			for (int i = 0; i < todos.length; i++) {
				todos[i] = SessionContent.fromJson(arrTodo.getJSONObject(i));
			}
			session.setTodo(todos);
		}
		JSONArray arrDue = obj.optJSONArray("aRendre");
		if (arrDue != null) {
			SessionContent[] dues = new SessionContent[arrDue.length()];
			for (int i = 0; i < dues.length; i++) {
				dues[i] = SessionContent.fromJson(arrDue.getJSONObject(i));
			}
			session.setDue(dues);
		}
		JSONArray arrInSession = obj.optJSONArray("enSeance");
		if (arrInSession != null) {
			SessionContent[] inSessions = new SessionContent[arrInSession.length()];
			for (int i = 0; i < inSessions.length; i++) {
				inSessions[i] = SessionContent.fromJson(arrInSession.getJSONObject(i));
			}
			session.setInSession(inSessions);
		}

		return session;
	}

}
