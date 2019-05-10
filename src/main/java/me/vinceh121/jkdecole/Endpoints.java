package me.vinceh121.jkdecole;

import java.util.HashMap;

public class Endpoints {
	private static final HashMap<String, String> endpoints = new HashMap<String, String>();

	static {
		endpoints.put("PA", "http://www.preprod.eap.entmip.fr/mobilite/");
		endpoints.put("PN", "http://mobilite.entmip.kdecole.fr/mobilite/");
		endpoints.put("EA", "https://mobilite.eap.entmip.fr/mobilite/");
		endpoints.put("EN", "https://mobilite.entmip.fr/mobilite/");
	}

	public static String getEndpoint(String prefix) {
		return endpoints.get(prefix);
	}
}
