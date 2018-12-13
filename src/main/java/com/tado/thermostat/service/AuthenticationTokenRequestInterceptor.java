package com.tado.thermostat.service;

/**
 * 
 * Interceptor for RestTemplate.
 * 
 * Add authenticationToken in request headers.
 *
 */
public class AuthenticationTokenRequestInterceptor extends HeaderRequestInterceptor {

	public AuthenticationTokenRequestInterceptor(String token) {
		super(token);
	}

}