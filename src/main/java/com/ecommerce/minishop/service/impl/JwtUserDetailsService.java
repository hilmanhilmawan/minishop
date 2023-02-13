package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.model.UserPrincipal;
import com.ecommerce.minishop.repository.UserLoginRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final UserLoginRepository userLoginRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserLogin> optionalUser = userLoginRepository.findByUsername(s);
        return optionalUser.map(UserPrincipal::new).orElseThrow(() -> new UsernameNotFoundException("user not found"));
    }
}
