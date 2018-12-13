package com.tado.thermostat.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ThermostatRequestDto implements Serializable {

	private static final long serialVersionUID = -2986892441759520314L;

	protected String requestId;
	protected List<AbstractInputDto> inputs;

	public String getRequestId() {
		return requestId;
	}

	public void setRequestId(String requestId) {
		this.requestId = requestId;
	}

	public List<AbstractInputDto> getInputs() {
		return inputs;
	}

	public void setInputs(List<AbstractInputDto> inputs) {
		this.inputs = inputs;
	}
}
