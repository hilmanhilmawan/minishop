package com.ecommerce.minishop.mapper;

import lombok.Getter;

@Getter
public enum Role {
    ADMIN(1, "ADMIN"),
    USER(2, "USER");

    private final int code;
    private final String description;

    Role(int code, String description) {
        this.code = code;
        this.description = description;
    }
}
