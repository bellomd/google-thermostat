package com.tado.thermostat.service;

import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

/**
 * 
 * Used in RestTemplate
 *
 */
public class HeaderRequestInterceptor implements ClientHttpRequestInterceptor {

	private final String token;

	/**
	 * 
	 * @param headerName
	 * @param headerValue
	 */
	public HeaderRequestInterceptor(String token) {
		this.token = token;
	}

	/**
	 * 
	 * @param request
	 * @param body
	 * @param execution
	 * @return
	 * @throws
	 */
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		request.getHeaders().add(HttpHeaders.AUTHORIZATION, "Bearer " + token);
		return execution.execute(request, body);
	}
}