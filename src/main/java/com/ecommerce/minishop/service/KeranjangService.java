package com.ecommerce.minishop.service;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.KeranjangRequest;
import com.ecommerce.minishop.response.KeranjangResponse;

import java.util.List;

public interface KeranjangService {
    String addKeranjang(KeranjangRequest keranjangRequest) throws RecordNotFoundException;
    List<KeranjangResponse> ListKeranjang(String username) throws RecordNotFoundException;
    void deleteKeranjangByRefId(String refid) throws RecordNotFoundException;
}
