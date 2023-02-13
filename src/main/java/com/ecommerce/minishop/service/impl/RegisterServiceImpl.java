package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.mapper.UserLoginMapper;
import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.repository.UserLoginRepository;
import com.ecommerce.minishop.request.RegisterRequest;
import com.ecommerce.minishop.service.RegisterService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegisterServiceImpl implements RegisterService {
    private final UserLoginMapper userLoginMapper;
    private final UserLoginRepository userLoginRepository;

    public void registerUser(RegisterRequest request) {
        UserLogin userLogin = userLoginMapper.toModel(request);
        userLoginRepository.save(userLogin);
    }
}
