package com.ecommerce.minishop.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ProsesOrder {
    @NotNull
    private String produkRefId;
    private String userId;
}
