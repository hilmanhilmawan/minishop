package com.ecommerce.minishop.response;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProdukResponse {
    private String refId;
    private String namaProduk;
    private String harga;
    private String deskripsi;
}
