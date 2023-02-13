package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.enums.ResponseCode;
import com.ecommerce.minishop.enums.ResponseMessage;
import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.mapper.ProdukMapper;
import com.ecommerce.minishop.model.Produk;
import com.ecommerce.minishop.repository.ProdukRepository;
import com.ecommerce.minishop.request.AddProdukRequest;
import com.ecommerce.minishop.request.EditProdukRequest;
import com.ecommerce.minishop.response.ProdukResponse;
import com.ecommerce.minishop.service.MasterProdukService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class MasterProdukServiceImpl implements MasterProdukService {
    private final ProdukRepository produkRepository;
    private final ProdukMapper produkMapper;

    private String getLikeString(String keyword) {
        return "%" + keyword + "%";
    }

    @Override
    public String addProduk(AddProdukRequest addProdukRequest) throws RecordNotFoundException {
        Produk produk = new Produk();
        produk.setNamaProduk(addProdukRequest.getNamaProduk());
        produk.setHarga(addProdukRequest.getHarga());
        produk.setDeskripsi(addProdukRequest.getDeskripsi());
        try {
            produkRepository.save(produk);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST.getCode(),
                    ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
        return produk.getRefId();
    }

    @Override
    public Page<ProdukResponse> getListMasterProduk(Pageable pageable) {
        Page<Produk> produks = produkRepository.findByIsDeletedTrue(pageable);
        return produks.map(produkMapper::convertToResponse);
    }

    @Override
    public Page<ProdukResponse> getListMasterProduk(String namaProduk, Pageable pageable) {
        Page<Produk> produks = produkRepository.findByIsDeletedTrueAndNamaProdukIgnoreCaseLike(getLikeString(namaProduk), pageable);
        return produks.map(produkMapper::convertToResponse);
    }

    @Override
    public ProdukResponse getDetailMasterProdukByRefid(String refid) throws RecordNotFoundException {
        Optional<Produk> produkOptional = produkRepository.findByRefId(refid);
        if (!produkOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        return produkMapper.convertToResponse(produkOptional.get());
    }

    @Override
    public String editProduk(EditProdukRequest editProdukRequest) throws RecordNotFoundException {
        Optional<Produk> produkOptional = produkRepository.findByRefId(editProdukRequest.getProdukRefid());
        System.out.println("Optional Produk => " + produkOptional);
        System.out.println("ID Produk => " + editProdukRequest.getProdukRefid());
        if (!produkOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        Produk produk = produkOptional.get();
        produk.setNamaProduk(editProdukRequest.getNamaProduk());
        produk.setHarga(editProdukRequest.getHarga());
        produk.setDeskripsi(editProdukRequest.getDeskripsi());
        try {
            produkRepository.save(produk);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST.getCode(),
                    ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
        return produk.getRefId();
    }

    @Override
    public void deleteProduk(String produkRefid) throws RecordNotFoundException {
        Optional<Produk> produkOptional = produkRepository.findByRefId(produkRefid);
        if (!produkOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        Produk produk = produkOptional.get();
        produk.setDeleted(false);
        try {
            produkRepository.save(produk);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST.getCode(),
                    ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
    }
}
