package me.vinceh121.jkdecole;

import java.util.HashMap;

public final class Endpoints {
	private static final HashMap<String, String> endpoints = new HashMap<>();

	static { // FIXME find a solution for dupes
		// From mon-ent-occitanie
		Endpoints.endpoints.put("PA", "http://www.preprod.eap.entmip.fr/mobilite/");
		Endpoints.endpoints.put("PN", "http://mobilite.entmip.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("EA", "https://mobilite.eap.mon-ent-occitanie.fr/mobilite/");
		Endpoints.endpoints.put("EN", "https://mobilite.mon-ent-occitanie.fr/mobilite/");

		// From Kdecole example/demo app
		Endpoints.endpoints.put("DE", "http://www.demo.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("DN", "http://www.demo-next.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("VI", "http://www.vitrine.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("EX", "http://www.explore.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("XP", "http://www.experience.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("WE", "http://www.webinaire.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("VE", "http://www.recette-vente.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("VS", "http://www.recette-ventes.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("D1", "http://www.modele-decouverte.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("D2", "http://www.sandbox.skolengo.com/mobilite/");
		Endpoints.endpoints.put("D3", "http://www.sandbox.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("D4", "http://www.demo.kosmoseducation.com/mobilite/");
		Endpoints.endpoints.put("D5", "http://www.decouverte.skolengo.com/mobilite/");
		Endpoints.endpoints.put("D6", "http://www.demo.skolengo.com/mobilite/");
		Endpoints.endpoints.put("PR", "https://mobilite.kosmoseducation.com/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.kosmoseducation.com/mobilite/");
		Endpoints.endpoints.put("PD", "https://mobilite.pdl.kosmoseducation.com/mobilite/");

		// From Arsene76
		Endpoints.endpoints.put("PR", "https://mobilite.arsene76.fr/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.arsene76.fr/mobilite/");

		// From ENT27
		Endpoints.endpoints.put("PR", "https://mobilite.ent27.fr/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.ent27.fr/mobilite/");

		// From ENTCreuse
		Endpoints.endpoints.put("PR", "https://mobilite.entcreuse.fr/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.entcreuse.fr/mobilite/");

		// From Ma Classe en Auvergne
		Endpoints.endpoints.put("PR", "https://mobilite.ent.auvergnerhonealpes.fr/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.elycee.rhonealpes.fr/mobilite/");

		// From Mon College Val d'Oise
		Endpoints.endpoints.put("PR", "https://mobilite.moncollege.valdoise.fr/mobilite/");
		Endpoints.endpoints.put("PP", "https://mobilite.preprod.moncollege.valdoise.fr/mobilite/");

		// From Savoirs Numériques
		Endpoints.endpoints.put("PR", "https://mobilite.savoirsnumeriques62.fr/mobilite/");
		Endpoints.endpoints.put("PP", "http://mobilite.preprod.savoirsnumeriques62.fr/mobilite/");
		Endpoints.endpoints.put("QU", "http://mobilite.qualification.savoirsnumeriques62.fr/mobilite/");
	}

	public static String getEndpoint(final String prefix) {
		return Endpoints.endpoints.get(prefix);
	}
}
