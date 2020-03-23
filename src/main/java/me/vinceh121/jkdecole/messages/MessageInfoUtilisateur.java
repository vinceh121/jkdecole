package me.vinceh121.jkdecole.messages;

import org.json.JSONObject;

public class MessageInfoUtilisateur {
	private String nom, idEleveSelectionne, idEtablissementSelectionne, protection, errmsg;
	private int type;
	private Etab[] etabs;

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getIdEleveSelectionne() {
		return this.idEleveSelectionne;
	}

	public void setIdEleveSelectionne(final String idEleveSelectionne) {
		this.idEleveSelectionne = idEleveSelectionne;
	}

	public String getIdEtablissementSelectionne() {
		return this.idEtablissementSelectionne;
	}

	public void setIdEtablissementSelectionne(final String idEtablissementSelectionne) {
		this.idEtablissementSelectionne = idEtablissementSelectionne;
	}

	public String getProtection() {
		return this.protection;
	}

	public void setProtection(final String protection) {
		this.protection = protection;
	}

	public int getType() {
		return this.type;
	}

	public void setType(final int type) {
		this.type = type;
	}

	public String getErrmsg() {
		return this.errmsg;
	}

	public void setErrmsg(final String errmsg) {
		this.errmsg = errmsg;
	}

	public static MessageInfoUtilisateur fromJson(final JSONObject obj) {
		final MessageInfoUtilisateur info = new MessageInfoUtilisateur();

		info.setErrmsg(obj.optString("errmsg")); // May be null

		info.setIdEleveSelectionne(obj.optString("idEleveSelectionne"));

		info.setIdEtablissementSelectionne(obj.optString("idEtablissementSelectionne"));
		info.setProtection(obj.optString("protection"));
		info.setType(obj.optInt("type"));
		info.setNom(obj.optString("nom"));
		if (obj.optJSONArray("etabs") != null) {
			final Etab[] etabs = new Etab[obj.optJSONArray("etabs").length()];
			for (int i = 0; i < etabs.length; i++)
				etabs[i] = Etab.fromJson(obj.getJSONArray("etabs").getJSONObject(i));
			info.setEtabs(etabs);
		}
		return info;
	}

	public Etab[] getEtabs() {
		return this.etabs;
	}

	public void setEtabs(final Etab[] etabs) {
		this.etabs = etabs;
	}

	public static class Etab {
		private boolean active;
		private String[] permissions;
		private String uid, nom;

		public boolean isActive() {
			return this.active;
		}

		public void setActive(final boolean active) {
			this.active = active;
		}

		public String[] getPermissions() {
			return this.permissions;
		}

		public void setPermissions(final String[] permissions) {
			this.permissions = permissions;
		}

		public String getUid() {
			return this.uid;
		}

		public void setUid(final String uid) {
			this.uid = uid;
		}

		public String getNom() {
			return this.nom;
		}

		public void setNom(final String nom) {
			this.nom = nom;
		}

		public static Etab fromJson(final JSONObject obj) {
			final Etab etab = new Etab();
			etab.setActive(obj.optBoolean("active"));
			etab.setNom(obj.optString("nom"));
			etab.setUid(obj.optString("uid"));
			etab.setPermissions(obj.optString("permissions").split(" "));
			return etab;
		}

	}

}
