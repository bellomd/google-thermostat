package com.tado.thermostat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class InputDto extends AbstractInputDto {

	private static final long serialVersionUID = 7247929959159459313L;
}
