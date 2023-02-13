package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.enums.ResponseCode;
import com.ecommerce.minishop.enums.ResponseMessage;
import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.mapper.KeranjangMapper;
import com.ecommerce.minishop.model.Keranjang;
import com.ecommerce.minishop.model.Produk;
import com.ecommerce.minishop.repository.KeranjangRepository;
import com.ecommerce.minishop.repository.ProdukRepository;
import com.ecommerce.minishop.request.KeranjangRequest;
import com.ecommerce.minishop.response.KeranjangResponse;
import com.ecommerce.minishop.service.KeranjangService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class KeranjangServiceImpl implements KeranjangService {
    private final KeranjangRepository keranjangRepository;
    private final ProdukRepository produkRepository;
    private final KeranjangMapper keranjangMapper;

    @Override
    public String addKeranjang(KeranjangRequest keranjangRequest) throws RecordNotFoundException {
        Optional<Produk> produkOptional = produkRepository.findByRefId(keranjangRequest.getProdukRefid());
        if (!produkOptional.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        Keranjang keranjang = new Keranjang();
        keranjang.setProduk(produkOptional.get());
        try {
            keranjang = keranjangRepository.save(keranjang);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST.getCode(),
                    ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
        return keranjang.getRefId();
    }

    @Override
    public List<KeranjangResponse> ListKeranjang(String username) throws RecordNotFoundException {
        Iterable<Keranjang> keranjangs = keranjangRepository.findByCreatorIdOrderByCreatorTimeDesc(username);
        if (keranjangs == null) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }

        List<KeranjangResponse> responseList = new ArrayList<>();
        for (Keranjang keranjang : keranjangs) {
            responseList.add(keranjangMapper.convertToResponse(keranjang));
        }
        return responseList;
    }

    @Override
    public void deleteKeranjangByRefId(String refid) throws RecordNotFoundException {
        Optional<Keranjang> keranjangs = keranjangRepository.findAllByRefId(refid);
        if (!keranjangs.isPresent()) {
            throw new RecordNotFoundException(HttpStatus.NOT_FOUND, ResponseCode.NOT_FOUND.getCode(),
                    ResponseMessage.NOT_FOUND.getMessage());
        }
        Keranjang keranjang = keranjangs.get();
        try {
            keranjangRepository.delete(keranjang);
        } catch (Exception e) {
            throw new RecordNotFoundException(HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST.getCode(),
                    ResponseMessage.FAILED_TO_SAVE_DATA.getMessage());
        }
    }
}
