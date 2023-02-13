package com.ecommerce.minishop.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class PaymentOrderRequest {
    @NotNull
    private String orderHdrId;
    private String nama;
    private int nohandPhone;
    private String alamat;
}
