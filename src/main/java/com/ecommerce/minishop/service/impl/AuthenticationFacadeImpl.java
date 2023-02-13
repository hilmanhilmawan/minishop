package com.ecommerce.minishop.service.impl;

import com.ecommerce.minishop.model.UserPrincipal;
import com.ecommerce.minishop.service.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthenticationFacadeImpl implements AuthenticationFacade {

	@Override
	public String getPrincipalUserName() {
		UserPrincipal userPrincipal = getPrincipal();
		return userPrincipal.getUsername();
	}

	@Override
	public Long getId() {
		UserPrincipal userPrincipal = getPrincipal();
		return userPrincipal.getId();
	}

	private UserPrincipal getPrincipal() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null) {
			return new UserPrincipal("SYSTEM");
		}

		return (UserPrincipal) authentication.getPrincipal();
	}
}
