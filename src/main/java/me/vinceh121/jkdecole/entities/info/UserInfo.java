package me.vinceh121.jkdecole.entities.info;

import java.util.List;

public class UserInfo {
	private String nom, idEleveSelectionne, idEtablissementSelectionne, protection;
	private int type;
	private List<Establishment> etabs;

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

	public List<Establishment> getEtabs() {
		return this.etabs;
	}

	public void setEtabs(final List<Establishment> etabs) {
		this.etabs = etabs;
	}

}
