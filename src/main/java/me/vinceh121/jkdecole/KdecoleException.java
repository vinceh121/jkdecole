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

	public KdecoleException(final JSONObject errmsg) {
		this.title = errmsg.optString("titre");
		this.code = errmsg.optInt("code");
		this.type = errmsg.optString("DROP");
		this.message = errmsg.optString("message");
		this.timeValid = errmsg.optInt("tempsValide");
	}

	public int getCode() {
		return this.code;
	}

	public int getTimeValid() {
		return this.timeValid;
	}

	public String getType() {
		return this.type;
	}

	public String getTitle() {
		return this.title;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

}
