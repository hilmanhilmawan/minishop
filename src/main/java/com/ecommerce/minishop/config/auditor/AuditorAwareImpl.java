package com.ecommerce.minishop.config.auditor;

import com.ecommerce.minishop.service.AuthenticationFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Component
public class AuditorAwareImpl implements AuditorAware<String> {
	@Autowired
	private AuthenticationFacade authenticationFacade;

	@Override
	public Optional<String> getCurrentAuditor() {
		String userName = authenticationFacade.getPrincipalUserName();
		if (isEmptyUser(userName) || isAnonymousUser(userName)) {
			return Optional.of("SYSTEM");
		}

		return Optional.of(userName);
	}

	private boolean isEmptyUser(String userName) {
		return !StringUtils.hasText(userName);
	}

	private boolean isAnonymousUser(String userName) {
		return userName.equalsIgnoreCase("anonymousUser");
	}
}