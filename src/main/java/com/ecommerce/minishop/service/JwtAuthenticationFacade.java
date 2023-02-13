package com.ecommerce.minishop.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtAuthenticationFacade {
    String generateToken(String subject);

    boolean isValidToken(String token, UserDetails userDetails);

    String getUsername(String token);
}
