package me.vinceh121.jkdecole;

import java.io.IOException;

import org.json.JSONObject;

/**
 * Example: {"errmsg":{"titre":"","code":4030,"type":"DROP","message":"Votre
 * accès mobile a expiré. Veuillez relancer la procédure
 * d'activation.","tempsvalide":0}}
 * 
 * @author vinceh121
 *
 */
public class KdecoleException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5568691018073075630L;

	private int code, timeValid;
	private String type, title, message;

	public KdecoleException(JSONObject errmsg) {
		title = errmsg.optString("titre");
		code = errmsg.optInt("code");
		type = errmsg.optString("DROP");
		message = errmsg.optString("message");
		timeValid = errmsg.optInt("tempsValide");
	}

	public int getCode() {
		return code;
	}

	public int getTimeValid() {
		return timeValid;
	}

	public String getType() {
		return type;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

}
