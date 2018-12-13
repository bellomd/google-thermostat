package com.tado.thermostat.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SyncRequestDto extends ThermostatRequestDto {

	private static final long serialVersionUID = 176999876811242668L;

	protected List<InputDto> inputs;
}
