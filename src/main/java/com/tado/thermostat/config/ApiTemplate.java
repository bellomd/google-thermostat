package com.tado.thermostat.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.password.ResourceOwnerPasswordResourceDetails;
import org.springframework.stereotype.Component;

import com.tado.thermostat.auth.TadoAuthentication;
import com.tado.thermostat.exception.TokenNotFoundException;
import com.tado.thermostat.service.AuthenticationTokenRequestInterceptor;

@Component
public class ApiTemplate {
	
	private final ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails;
	
	@Autowired
	public ApiTemplate(ResourceOwnerPasswordResourceDetails resourceOwnerPasswordResourceDetails) {
		this.resourceOwnerPasswordResourceDetails = resourceOwnerPasswordResourceDetails;
	}
	
	public OAuth2RestTemplate getTemplate() {
		
		final OAuth2RestTemplate template = new OAuth2RestTemplate(resourceOwnerPasswordResourceDetails);
		template.setInterceptors(Collections.singletonList(getInterceptor()));
		
		return template;
	}
	
	public AuthenticationTokenRequestInterceptor getInterceptor() {
		
		final SecurityContext securityContext = SecurityContextHolder.getContext();
		
		if (securityContext != null) {
			
			final Authentication authentication = securityContext.getAuthentication();
			
			if (authentication instanceof TadoAuthentication) {
				final TadoAuthentication tadoAuthentication = (TadoAuthentication) authentication;
				final String token = tadoAuthentication.getToken();
				return new AuthenticationTokenRequestInterceptor(token);
			}
		}
		
		throw new TokenNotFoundException("Token not found");
	}
}
