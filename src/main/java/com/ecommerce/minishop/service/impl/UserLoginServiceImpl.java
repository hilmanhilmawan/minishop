package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.repository.UserLoginRepository;
import com.ecommerce.minishop.service.UserLoginService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserLoginServiceImpl implements UserLoginService {
    private final UserLoginRepository userLoginRepository;
    @Override
    public UserLogin getUser(String username) {
        Optional<UserLogin> userLogin = userLoginRepository.findByUsername(username);
        if (userLogin.isPresent()) {
            return userLogin.get();
        }

        return null;
    }
}
