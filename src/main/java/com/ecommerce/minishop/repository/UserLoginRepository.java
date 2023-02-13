package com.ecommerce.minishop.repository;

import com.ecommerce.minishop.model.UserLogin;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserLoginRepository extends CrudRepository<UserLogin, Integer> {
    Optional<UserLogin> findByUsername(String username);
}
