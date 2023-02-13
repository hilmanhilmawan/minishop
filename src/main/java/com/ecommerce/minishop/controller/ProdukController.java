package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.response.ProdukResponse;
import com.ecommerce.minishop.service.ProdukService;
import com.ecommerce.minishop.util.PageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/produk")
public class ProdukController {
    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "16";
    public static final String DEFAULT_SORT = "id,desc";

    private final ProdukService produkService;

    @Qualifier("PageDetailContent")
    PageBuilder pageBuilder;

    @GetMapping("/list")
    public ApiResponse<?> getProdukList(
            @RequestParam String namaProduk,
            @RequestParam(defaultValue = DEFAULT_PAGE_NO) Integer pageNo,
            @RequestParam(defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize,
            @RequestParam (defaultValue = DEFAULT_SORT) String sortBy) {
        List<Sort.Order> orders = pageBuilder.splitOrder(sortBy);
        Pageable listPageable = pageBuilder.buildPageRequest(pageNo, pageSize, Sort.by(orders));
        Page<ProdukResponse> produkResponses;
        if (StringUtils.isEmpty(namaProduk)) {
            produkResponses = produkService.getListProduk(listPageable);
        } else {
            produkResponses = produkService.getListProduk(namaProduk, listPageable);
        }
        return ApiResponse.success(produkResponses);
    }

    @GetMapping("/detail")
    public ApiResponse<?> getDetailProdukByRefid(@RequestParam String refid) throws RecordNotFoundException {
        return ApiResponse.success(produkService.getDetailProdukByRefid(refid));
    }
}
