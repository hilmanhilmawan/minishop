package com.ecommerce.minishop.service;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.response.ProdukResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProdukService {
    Page<ProdukResponse> getListProduk(Pageable pageable);
    Page<ProdukResponse> getListProduk(String namaProduk, Pageable pageable);
    ProdukResponse getDetailProdukByRefid(String refid) throws RecordNotFoundException;
}
