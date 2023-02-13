package com.ecommerce.minishop.mapper;

import com.ecommerce.minishop.model.Keranjang;
import com.ecommerce.minishop.response.KeranjangResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public abstract class KeranjangMapper {
    @Mappings({

            @Mapping(target = "refId", source = "refId"),
            @Mapping(target = "produkRefid", source = "produk.refId"),
            @Mapping(target = "namaProduk", source = "produk.namaProduk"),
            @Mapping(target = "qty", source = "qty"),
            @Mapping(target = "totalHarga", source = "produk.harga"),
            @Mapping(target = "deskripsi", source = "produk.deskripsi"),
            @Mapping(target = "fullName", source = "userLogin.fullname")
    })
    public abstract KeranjangResponse convertToResponse(Keranjang keranjang);
}
