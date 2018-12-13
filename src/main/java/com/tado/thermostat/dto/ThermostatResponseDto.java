package com.tado.thermostat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class ThermostatResponseDto implements Serializable {

	private static final long serialVersionUID = 2080757550147519469L;
	
	private String requestId;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}
}
