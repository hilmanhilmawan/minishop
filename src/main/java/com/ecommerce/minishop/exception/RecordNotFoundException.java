package com.ecommerce.minishop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;
	private HttpStatus httpStatus;
	private int code;
	private String message;

	public RecordNotFoundException(HttpStatus httpStatus, int code, String message) {
		super(message);
		this.httpStatus = httpStatus;
		this.code = code;
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public int getCode() {
		return code;
	}

	public RecordNotFoundException(String message, Throwable t) {
		super(message, t);
	}
}
