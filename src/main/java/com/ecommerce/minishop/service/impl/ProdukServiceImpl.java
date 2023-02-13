package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.enums.ResponseCode;
import com.ecommerce.minishop.enums.ResponseMessage;
import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.mapper.ProdukMapper;
import com.ecommerce.minishop.model.Produk;
import com.ecommerce.minishop.repository.ProdukRepository;
import com.ecommerce.minishop.response.ProdukResponse;
import com.ecommerce.minishop.service.ProdukService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProdukServiceImpl implements ProdukService {
    private final ProdukRepository produkRepository;
    private final ProdukMapper produkMapper;

    private String getLikeString(String keyword) {
        return "%" + keyword + "%";
    }

    @Override
    public Page<ProdukResponse> getListProduk(Pageable pageable) {
        Page<Produk> produks = produkRepository.findByIsDeletedTrue(pageable);
        return produks.map(produkMapper::convertToResponse);
    }

    @Override
    public Page<ProdukResponse> getListProduk(String namaProduk, Pageable pageable) {
        Page<Produk> produks = produkRepository.findByIsDeletedTrueAndNamaProdukIgnoreCaseLike(getLikeString(namaProduk), pageable);
        return produks.map(produkMapper::convertToResponse);
    }

    @Override
    public ProdukResponse getDetailProdukByRefid(String refid) throws RecordNotFoundException {
        Optional<Produk> produkOptional = produkRepository.findByRefId(refid);
        if (!produkOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        return produkMapper.convertToResponse(produkOptional.get());
    }
}
