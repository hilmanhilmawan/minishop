package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.AddProdukRequest;
import com.ecommerce.minishop.request.EditProdukRequest;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.response.ProdukResponse;
import com.ecommerce.minishop.service.MasterProdukService;
import com.ecommerce.minishop.util.PageBuilder;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.util.StringUtils;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/master-produk")
public class MasterProdukController {
    public static final String DEFAULT_PAGE_NO = "0";
    public static final String DEFAULT_PAGE_SIZE = "16";
    public static final String DEFAULT_SORT = "id,desc";

    private final MasterProdukService masterProdukService;

    @Qualifier("PageDetailContent")
    PageBuilder pageBuilder;

    @PostMapping("/add")
    public ApiResponse<?> addProduk(
            @RequestBody AddProdukRequest addProdukRequest) throws RecordNotFoundException {
        return ApiResponse.success(masterProdukService.addProduk(addProdukRequest));
    }

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
            produkResponses = masterProdukService.getListMasterProduk(listPageable);
        } else {
            produkResponses = masterProdukService.getListMasterProduk(namaProduk, listPageable);
        }
        return ApiResponse.success(produkResponses);
    }

    @GetMapping("/detail")
    public ApiResponse<?> getDetailProdukByRefid(@RequestParam String refid) throws RecordNotFoundException {
        return ApiResponse.success(masterProdukService.getDetailMasterProdukByRefid(refid));
    }

    @PutMapping("/edit")
    public ApiResponse<?> editProduk(
            @RequestBody EditProdukRequest editProdukRequest) throws RecordNotFoundException {
        System.out.println("ID Produk => " + editProdukRequest.getProdukRefid());
        return ApiResponse.success(masterProdukService.editProduk(editProdukRequest));
    }

    @PostMapping("/delete")
    public ApiResponse<?> deleteProduk(@RequestParam String produkRefid) throws RecordNotFoundException {
        masterProdukService.deleteProduk(produkRefid);
        return ApiResponse.success("Delete Berhasil");
    }
}
