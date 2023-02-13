package com.ecommerce.minishop.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InvalidPageRequest extends RuntimeException {
    private final String message;
}