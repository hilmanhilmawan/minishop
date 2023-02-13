package com.ecommerce.minishop.enums;

import lombok.Getter;

@Getter
public enum ResponseMessage {
	SUCCESS("Success"),
	DATA_NOT_COMPLETE("please fill all field"),
	EMAIL_VERIFICATION("email invalid or domain must be @jdlexpress.co.id"),
	FAILED_TO_SAVE_DATA("failed to save data"),
	NOT_FOUND("data not found"),
	IF_EXIST("data is exist"),
	DUPLICATE_DATA("data duplicated, please check again"),
	STATUS_VERIFIED("bad request status"),
	ROLE_NOT_FOUND("role not found"),
	STATUS_NOT_FOUND("status not found"),
	FAILED_TO_DELETE("failed to delete data"),
	CONDITION_NOT_FOUND("condition not found"),
	CONDITION_INVALID("condition must be available"),
	PROCESS_TYPE_INVALID("Process Type Invalid"),
	CATALOG_NOT_FOUND("catalog not found"),
	OWNERSHIP_NOT_RENT("ownership must be of the type of rent"),
	STATUS_INVALID_("status asset invalid"),
	BRAND_NOT_FOUND("brand not found"),
	TYPE_NOT_FOUND("type not found"),
	FORBIDDEN("Forbidden"),
	EMAIL_NOT_SEND("Failed To Send Email");

	private final String message;

	ResponseMessage(String message) {
		this.message = message;
	}
}