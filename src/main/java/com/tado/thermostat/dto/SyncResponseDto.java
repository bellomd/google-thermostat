package com.tado.thermostat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncResponseDto extends ThermostatResponseDto {

	private static final long serialVersionUID = 1035562401986905241L;
	
	private PayloadDto payload;

	public PayloadDto getPayload() {
		return payload;
	}

	public void setPayload(PayloadDto payload) {
		this.payload = payload;
	}
}
