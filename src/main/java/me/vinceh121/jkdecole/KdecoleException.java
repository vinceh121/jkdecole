package me.vinceh121.jkdecole;

import java.io.IOException;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Example: {"errmsg":{"titre":"","code":4030,"type":"DROP","message":"Votre
 * accès mobile a expiré. Veuillez relancer la procédure
 * d'activation.","tempsvalide":0}}
 *
 * @author vinceh121
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class KdecoleException extends IOException {
	private static final long serialVersionUID = -5568691018073075630L;

	private int code, timeValid;
	private String type, title, message;

	public KdecoleException() {
	}

	public int getCode() {
		return this.code;
	}

	public void setCode(final int code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return this.message;
	}

	public void setMessage(final String message) {
		this.message = message;
	}

	@JsonProperty("tempsValide")
	public int getTimeValid() {
		return this.timeValid;
	}

	@JsonProperty("tempsValide")
	public void setTimeValid(final int timeValid) {
		this.timeValid = timeValid;
	}

	@JsonProperty("titre")
	public String getTitle() {
		return this.title;
	}

	@JsonProperty("titre")
	public void setTitle(final String title) {
		this.title = title;
	}

	public String getType() {
		return this.type;
	}

	public void setType(final String type) {
		this.type = type;
	}

}
