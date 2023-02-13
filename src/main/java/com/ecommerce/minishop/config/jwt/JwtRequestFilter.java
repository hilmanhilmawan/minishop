package com.ecommerce.minishop.config.jwt;

import com.ecommerce.minishop.service.JwtAuthenticationFacade;
import com.ecommerce.minishop.service.impl.JwtUserDetailsService;
import javax.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@AllArgsConstructor
public class JwtRequestFilter extends OncePerRequestFilter {
	private static final String AUTHORIZATION_HEADER = "Authorization";
	private static final String BEARER = "Bearer ";
	private static final int TOKEN_START_INDEX = 7;

	private final JwtUserDetailsService jwtUserDetailsService;
	private final JwtAuthenticationFacade jwtAuthenticationFacade;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
									FilterChain filterChain) throws ServletException, IOException {

		final String authHeader = request.getHeader(AUTHORIZATION_HEADER);
		if (validHeader(authHeader)) {
			String jwtToken = authHeader.substring(TOKEN_START_INDEX);
			String username = jwtAuthenticationFacade.getUsername(jwtToken);

			if (notEmpty(username) && emptyAuthenticationContext()) {
				validateToken(request, jwtToken, username);
			}
		}

		filterChain.doFilter(request, response);
	}

	private void validateToken(HttpServletRequest request, String jwtToken, String username) {
		UserDetails userDetails = jwtUserDetailsService.loadUserByUsername(username);

		if (jwtAuthenticationFacade.isValidToken(jwtToken, userDetails)) {
			UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
				userDetails, null, userDetails.getAuthorities());
			authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(authentication);
		}
	}

	private boolean validHeader(String requestTokenHeader) {
		return requestTokenHeader != null && requestTokenHeader.startsWith(BEARER);
	}

	private boolean notEmpty(String s) {
		return StringUtils.hasText(s);
	}

	private boolean emptyAuthenticationContext() {
		return SecurityContextHolder.getContext().getAuthentication() == null;
	}

}
