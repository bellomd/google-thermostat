package com.tado.thermostat.dto;

import java.io.Serializable;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponsePayloadDto implements Serializable {

	private static final long serialVersionUID = -8245445158595837836L;

	private Map<String, QueryResponseDiviceDto> devices;

	public Map<String, QueryResponseDiviceDto> getDevices() {
		return devices;
	}

	public void setDevices(Map<String, QueryResponseDiviceDto> devices) {
		this.devices = devices;
	}
}
