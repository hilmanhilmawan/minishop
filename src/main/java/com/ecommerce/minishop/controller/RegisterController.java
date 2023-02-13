package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.request.RegisterRequest;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RegisterController {
    private final RegisterService registerService;

    @PostMapping("/users")
    public ApiResponse<?> register(@RequestBody RegisterRequest request) {
        registerService.registerUser(request);
        return ApiResponse.success("ok");
    }
}
