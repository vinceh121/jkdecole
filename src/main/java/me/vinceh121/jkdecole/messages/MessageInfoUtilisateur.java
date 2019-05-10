package me.vinceh121.jkdecole.messages;

import org.json.JSONObject;

public class MessageInfoUtilisateur {
	private String nom, idEleveSelectionne, idEtablissementSelectionne, protection, errmsg;
	private int type;
	private Etab[] etabs;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getIdEleveSelectionne() {
		return idEleveSelectionne;
	}

	public void setIdEleveSelectionne(String idEleveSelectionne) {
		this.idEleveSelectionne = idEleveSelectionne;
	}

	public String getIdEtablissementSelectionne() {
		return idEtablissementSelectionne;
	}

	public void setIdEtablissementSelectionne(String idEtablissementSelectionne) {
		this.idEtablissementSelectionne = idEtablissementSelectionne;
	}

	public String getProtection() {
		return protection;
	}

	public void setProtection(String protection) {
		this.protection = protection;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public static MessageInfoUtilisateur fromJson(JSONObject obj) {
		MessageInfoUtilisateur info = new MessageInfoUtilisateur();

		info.setErrmsg(obj.optString("errmsg")); // May be null

		info.setIdEleveSelectionne(obj.optString("idEleveSelectionne"));

		info.setIdEtablissementSelectionne(obj.optString("idEtablissementSelectionne"));
		info.setProtection(obj.optString("protection"));
		info.setType(obj.optInt("type"));
		info.setNom(obj.optString("nom"));
		if (obj.optJSONArray("etabs") != null) {
			Etab[] etabs = new Etab[obj.optJSONArray("etabs").length()];
			for (int i = 0; i < etabs.length; i++) {
				etabs[i] = Etab.fromJson(obj.getJSONArray("etabs").getJSONObject(i));
			}
			info.setEtabs(etabs);
		}
		return info;
	}

	public Etab[] getEtabs() {
		return etabs;
	}

	public void setEtabs(Etab[] etabs) {
		this.etabs = etabs;
	}

	public static class Etab {
		private boolean active;
		private String[] permissions;
		private String uid, nom;

		public boolean isActive() {
			return active;
		}

		public void setActive(boolean active) {
			this.active = active;
		}

		public String[] getPermissions() {
			return permissions;
		}

		public void setPermissions(String[] permissions) {
			this.permissions = permissions;
		}

		public String getUid() {
			return uid;
		}

		public void setUid(String uid) {
			this.uid = uid;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public static Etab fromJson(JSONObject obj) {
			Etab etab = new Etab();
			etab.setActive(obj.optBoolean("active"));
			etab.setNom(obj.optString("nom"));
			etab.setUid(obj.optString("uid"));
			etab.setPermissions(obj.optString("permissions").split(" "));
			return etab;
		}

	}

}
