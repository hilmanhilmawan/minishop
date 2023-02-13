package com.ecommerce.minishop.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class AddProdukRequest {
    @NotNull
    private String namaProduk;
    @NotNull
    private double harga;
    @NotNull
    private String deskripsi;
}
