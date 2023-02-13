package com.ecommerce.minishop.service;

import com.ecommerce.minishop.response.LoginResponse;

public interface LoginService {
    public LoginResponse login(String username, String password);
}
