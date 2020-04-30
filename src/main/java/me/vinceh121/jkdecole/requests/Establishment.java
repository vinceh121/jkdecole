package me.vinceh121.jkdecole.requests;

public class Establishment {
	private boolean active;
	private String uid, nom, permissions;

	public boolean isActive() {
		return this.active;
	}

	public void setActive(final boolean active) {
		this.active = active;
	}

	public String getPermissions() {
		return this.permissions;
	}

	public void setPermissions(final String permissions) {
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
}
