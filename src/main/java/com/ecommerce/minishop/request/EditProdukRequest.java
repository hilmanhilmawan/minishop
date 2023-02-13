package com.ecommerce.minishop.request;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class EditProdukRequest {
    @NotNull
    private String produkRefid;
    @NotNull
    private String namaProduk;
    private double harga;
    private String deskripsi;
}
