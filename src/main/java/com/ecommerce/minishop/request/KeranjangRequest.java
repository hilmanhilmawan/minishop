package com.ecommerce.minishop.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class KeranjangRequest {
    @NotNull
    private String produkRefid;
}
