package com.ecommerce.minishop.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KeranjangResponse {
    private String refId;
    private String produkRefid;
    private String namaProduk;
    private int qty;
    private double totalHarga;
    private String deskripsi;
    private String fullName;
}
