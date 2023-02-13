package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.KeranjangRequest;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.service.KeranjangService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/keranjang")
public class KeranjangController {
    private final KeranjangService keranjangService;

    @PostMapping("/add")
    public ApiResponse<?> addKeranjang(
            @RequestBody KeranjangRequest keranjangRequest
            ) throws RecordNotFoundException {
        return ApiResponse.success(keranjangService.addKeranjang(keranjangRequest));
    }

    @GetMapping("/detail")
    public ApiResponse<?> ListKeranjang(@RequestParam String username) throws RecordNotFoundException {
        return ApiResponse.success(keranjangService.ListKeranjang(username));
    }

    @DeleteMapping("/delete/{keranjangRefId}")
    public ApiResponse<?> deleteKeranjangById(@PathVariable("keranjangRefId") String keranjangRefId) throws RecordNotFoundException {
        keranjangService.deleteKeranjangByRefId(keranjangRefId);
        return ApiResponse.success("Success");
    }
}
