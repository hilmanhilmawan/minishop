package com.ecommerce.minishop.response;

import com.ecommerce.minishop.enums.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private boolean success;
    private int status;
    private T result;
    private String message;

    public static <T> ApiResponse<T> success(T result) {
        return new ApiResponse<>(true, ResponseCode.SUCCESS.getCode(), result, ResponseCode.SUCCESS.getMessage());
    }

    public static ApiResponse<?> noContent() {
        return new ApiResponse<>(true, ResponseCode.NO_CONTENT.getCode(), null, ResponseCode.NO_CONTENT.getMessage());
    }

    public static <T> ApiResponse<T> badRequest(T result) {
        return new ApiResponse<>(false, ResponseCode.BAD_REQUEST.getCode(), result, ResponseCode.BAD_REQUEST.getMessage());
    }

    public static <T> ApiResponse<T> notFound(T result) {
        return new ApiResponse<>(false, ResponseCode.NOT_FOUND.getCode(), result, ResponseCode.NOT_FOUND.getMessage());
    }

    public static <T> ApiResponse<T> generalError() {
        return new ApiResponse<>(false, ResponseCode.GENERAL_ERROR.getCode(), null, ResponseCode.GENERAL_ERROR.getMessage());
    }

    public static <T> ApiResponse<T> unauthorized() {
        return new ApiResponse<>(false, 401, null, "Unauthorized");
    }

}