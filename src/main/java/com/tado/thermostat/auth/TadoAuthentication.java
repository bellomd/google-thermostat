package com.tado.thermostat.auth;

import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class TadoAuthentication implements Authentication {

	private static final long serialVersionUID = -5187747489397998246L;
	
	private final String token;
	
	public TadoAuthentication(final String token) {
		this.token = token;
	}
	
	@Override
	public String getName() {
		return getTokenPrincipal(token);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public Object getCredentials() {
		return null;
	}

	@Override
	public Object getDetails() {
		return null;
	}

	@Override
	public Object getPrincipal() {
		return getTokenPrincipal(token);
	}

	@Override
	public boolean isAuthenticated() {
		return true;
	}

	@Override
	public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
		
	}
	
	public String getToken() {
		return token;
	}
	
	private String getTokenPrincipal(final String token) {
		return token.substring(0, token.indexOf('.'));
	}
}
