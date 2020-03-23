package me.vinceh121.jkdecole;

import java.util.HashMap;

public final class Endpoints {
	private static final HashMap<String, String> endpoints = new HashMap<String, String>();

	static {
		Endpoints.endpoints.put("PA", "http://www.preprod.eap.entmip.fr/mobilite/");
		Endpoints.endpoints.put("PN", "http://mobilite.entmip.kdecole.fr/mobilite/");
		Endpoints.endpoints.put("EA", "https://mobilite.eap.entmip.fr/mobilite/");
		Endpoints.endpoints.put("EN", "https://mobilite.entmip.fr/mobilite/");
	}

	public static String getEndpoint(final String prefix) {
		return Endpoints.endpoints.get(prefix);
	}
}
