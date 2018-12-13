package com.tado.thermostat.auth;

import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

import com.tado.thermostat.exception.TokenNotFoundException;

@Service
public class TadoAuth2TokenProvider implements Auth2TokenProvider {
	
	private static final String TOKEN_BEARER = "Bearer ";

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		final Optional<Object> tokenObject = Optional.ofNullable(authentication.getPrincipal());
		
		if (!tokenObject.isPresent()) {
			
			throw new TokenNotFoundException("Authorization token is not found");
		}
		
		String token = (String) tokenObject.get();
		
		if (token.startsWith(TOKEN_BEARER)) {
			token = token.replace(TOKEN_BEARER, "");
		}
		
		return new TadoAuthentication(token);
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return true;
	}
}
