package com.ecommerce.minishop.dto;

import com.ecommerce.minishop.response.KeranjangResponse;
import lombok.*;

import java.util.List;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class KeranjangDto {
    private List<KeranjangResponse> keranjangProdukDto;
    private double totalHarga;
}
