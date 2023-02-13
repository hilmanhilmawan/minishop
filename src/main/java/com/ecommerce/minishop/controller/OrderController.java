package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.exception.RecordNotFoundException;
import com.ecommerce.minishop.request.CheckoutOrderRequest;
import com.ecommerce.minishop.request.PaymentOrderRequest;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/checkout")
    public ApiResponse<?> checkout(
            @RequestBody List<CheckoutOrderRequest> listCheckoutOrder) throws RecordNotFoundException {
        orderService.checkout(listCheckoutOrder);
        return ApiResponse.success("Success");
    }

    @PutMapping("/proses")
    public ApiResponse<?> lanjutProses(
            @RequestBody PaymentOrderRequest paymentOrderRequest) throws RecordNotFoundException {
        orderService.prosesPembayaran(paymentOrderRequest);
        return ApiResponse.success("Success");
    }
}
