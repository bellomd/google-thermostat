package com.tado.thermostat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryDeiceDto implements Serializable {

	private static final long serialVersionUID = 8448606838061132682L;

	private String id;
	private CustomDataDto customData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public CustomDataDto getCustomData() {
		return customData;
	}

	public void setCustomData(CustomDataDto customData) {
		this.customData = customData;
	}
}
