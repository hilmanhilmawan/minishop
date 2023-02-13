package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.service.JwtAuthenticationFacade;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtAuthenticationFacadeImpl implements JwtAuthenticationFacade {
    @Override
    public String generateToken(String subject) {
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 86400 * 1000))
                .signWith(SignatureAlgorithm.HS512, "WK0XBEQOSF4WU9DB5KJ24AYBDWA6W8WQ").compact();
    }

    @Override
    public boolean isValidToken(String token, UserDetails userDetails) {
        final String username = getUsername(token);
        return (username.equals(userDetails.getUsername()) && !isExpired(token));
    }

    @Override
    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    private boolean isExpired(String token) {
        final Date expiration = getExpiration(token);
        return expiration.before(new Date());
    }

    private Date getExpiration(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    private <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaims(String token) {
        try {
            return Jwts.parser().setSigningKey("WK0XBEQOSF4WU9DB5KJ24AYBDWA6W8WQ").parseClaimsJws(token).getBody();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
