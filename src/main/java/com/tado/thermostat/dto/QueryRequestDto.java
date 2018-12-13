package com.tado.thermostat.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryRequestDto extends ThermostatRequestDto {

	private static final long serialVersionUID = -4535035759534541463L;

	protected List<AbstractInputDto> inputs;

	public List<AbstractInputDto> getInputs() {
		return inputs;
	}

	public void setInputs(List<AbstractInputDto> inputs) {
		this.inputs = inputs;
	}
}
