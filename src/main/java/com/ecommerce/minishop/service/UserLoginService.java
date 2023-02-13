package com.ecommerce.minishop.service;

import com.ecommerce.minishop.model.UserLogin;

public interface UserLoginService {
    UserLogin getUser(String username);
}
