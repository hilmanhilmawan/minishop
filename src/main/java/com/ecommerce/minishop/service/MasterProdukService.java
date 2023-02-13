package com.ecommerce.minishop.service;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.AddProdukRequest;
import com.ecommerce.minishop.request.EditProdukRequest;
import com.ecommerce.minishop.response.ProdukResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MasterProdukService {
    String addProduk(AddProdukRequest addProdukRequest) throws RecordNotFoundException;
    Page<ProdukResponse> getListMasterProduk(Pageable pageable);
    Page<ProdukResponse> getListMasterProduk(String namaProduk, Pageable pageable);
    ProdukResponse getDetailMasterProdukByRefid(String refid) throws RecordNotFoundException;
    String editProduk(EditProdukRequest editProdukRequest) throws RecordNotFoundException;
    void deleteProduk(String produkRefid) throws RecordNotFoundException;
}
