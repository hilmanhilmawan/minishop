package com.ecommerce.minishop.request;

import lombok.Data;

@Data
public class CheckoutOrderRequest {
    private String userId;
    private String produkRefId;
    private int qty;
    private double totalHarga;
}
