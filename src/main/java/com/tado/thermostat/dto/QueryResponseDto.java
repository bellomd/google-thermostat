package com.tado.thermostat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponseDto extends ThermostatResponseDto {

	private static final long serialVersionUID = 5034250607865847848L;

	private String requestId;
	private QueryResponsePayloadDto payload;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public QueryResponsePayloadDto getPayload() {
		return payload;
	}

	public void setPayload(QueryResponsePayloadDto payload) {
		this.payload = payload;
	}
}
