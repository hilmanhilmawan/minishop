package com.ecommerce.minishop.request;

import com.ecommerce.minishop.mapper.Role;
import lombok.Data;

@Data
public class RegisterRequest {
    private String username;
    private String password;
    private String fullname;
    private String email;
    private String phoneNumber;
    private Role role;
}
