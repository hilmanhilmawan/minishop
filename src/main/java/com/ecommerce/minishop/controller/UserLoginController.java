package com.ecommerce.minishop.controller;

import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.response.ApiResponse;
import com.ecommerce.minishop.service.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserLoginController {
    private final UserLoginService userLoginService;

    @GetMapping("/users")
    public ApiResponse<?> getUser(@RequestParam String username) {
        UserLogin userLogin = userLoginService.getUser(username);
        return ApiResponse.success(userLogin.getUsername());
    }
}
