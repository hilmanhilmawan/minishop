package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.response.LoginResponse;
import com.ecommerce.minishop.service.JwtAuthenticationFacade;
import com.ecommerce.minishop.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService {
    private final AuthenticationManager authenticationManager;
    private final JwtAuthenticationFacade jwtAuthenticationFacade;
    @Override
    public LoginResponse login(String username, String password) {
        authenticate(username, password);

        String token = jwtAuthenticationFacade.generateToken(username);
        return new LoginResponse(token);
    }

    private void authenticate(String username, String password) {
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            authenticationManager.authenticate(authentication);
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("unauthorized");
        }
    }
}
