package com.ecommerce.minishop.config.jwt;

import com.ecommerce.minishop.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.OAuth2AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint extends OAuth2AuthenticationEntryPoint {
    @Override
    protected ResponseEntity<?> enhanceResponse(ResponseEntity<?> response, Exception exception) {
        ApiResponse<?> res = ApiResponse.unauthorized();
        return new ResponseEntity<>(res, HttpStatus.UNAUTHORIZED);
    }
}
