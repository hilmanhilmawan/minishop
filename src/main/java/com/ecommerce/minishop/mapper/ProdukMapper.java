package com.ecommerce.minishop.mapper;

import com.ecommerce.minishop.model.Produk;
import com.ecommerce.minishop.response.ProdukResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class ProdukMapper {
    public abstract ProdukResponse convertToResponse(Produk produk);
}
