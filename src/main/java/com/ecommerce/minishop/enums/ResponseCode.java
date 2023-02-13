package com.ecommerce.minishop.enums;

import lombok.Getter;

@Getter
public enum ResponseCode {
	SUCCESS(200, "Success"),
	NO_CONTENT(204, "Success"),
	BAD_REQUEST(400, "Bad Request"),
	UNAUTHORIZED(401, "Unauthorized"),
	NOT_FOUND(404, "Not Found"),
	NOT_ACCEPTABLE(406,"Not Accept"),
	GENERAL_ERROR(500, "Error System, Please Contact Administrator"),
	FORBIDDEN(403, "Forbidden");

	private final int code;
	private final String message;

	ResponseCode(int code, String message) {
		this.code = code;
		this.message = message;
	}
}