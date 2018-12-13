package com.tado.thermostat.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryPayloadDto implements Serializable {

	private static final long serialVersionUID = 4486224854480682187L;

	private List<QueryDeiceDto> devices;

	public List<QueryDeiceDto> getDevices() {
		return devices;
	}

	public void setDevices(List<QueryDeiceDto> devices) {
		this.devices = devices;
	}
}
