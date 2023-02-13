package com.ecommerce.minishop.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusCode {
    DALAM_PROSES("1"),
    MENUNGGU_PEMBAYARAN("2"),
    SELESAI("3");

    private String code;
}
