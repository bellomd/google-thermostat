package com.tado.thermostat.web;

import com.tado.thermostat.dto.ThermostatRequestDto;
import com.tado.thermostat.dto.ThermostatResponseDto;

public interface ThermostatRestService {

	static final String SYNC_API_PATH = "/thermostat/request";

	/**
	 * Get the result of the request based on the intent of the request.
	 * 
	 * @param thermostatRequestDto
	 * @return
	 */
	ThermostatResponseDto thermostat(final ThermostatRequestDto thermostatRequestDto);
}
