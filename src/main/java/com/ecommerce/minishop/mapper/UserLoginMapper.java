package com.ecommerce.minishop.mapper;

import com.ecommerce.minishop.model.UserLogin;
import com.ecommerce.minishop.request.RegisterRequest;
import org.mapstruct.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.UUID;

@Mapper(componentModel = "spring")
public abstract class UserLoginMapper {
    @Mappings({
            @Mapping(target = "roleId", source = "role.code"),
            @Mapping(target = "noHandphone", source = "phoneNumber")
    })
    public abstract UserLogin toModel(RegisterRequest request);

    @AfterMapping
    protected void setAdditional(@MappingTarget UserLogin target, RegisterRequest request) {
        target.setRefId(UUID.randomUUID().toString());

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        target.setPassword(bCryptPasswordEncoder.encode(request.getPassword()));
    }
}
