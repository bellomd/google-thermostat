package com.tado.thermostat.service;

import com.tado.thermostat.dto.ThermostatRequestDto;
import com.tado.thermostat.dto.ThermostatResponseDto;

public interface ThermostatService {

	/**
	 * Get the result of the request based on the intent of the request.
	 * 
	 * @param thermostatRequestDto
	 * @return
	 */
	ThermostatResponseDto thermostat(final ThermostatRequestDto thermostatRequestDto);

	/**
	 * Get the details of a user with the given token.
	 * 
	 * @param thermostatRequestDto
	 * @return ThermostatResponseDto
	 */
	ThermostatResponseDto sync(final ThermostatRequestDto syncRequestDto);

	/**
	 * Query the api and set value for the given request details
	 * 
	 * @param thermostatRequestDto
	 * @return ThermostatResponseDto
	 */
	ThermostatResponseDto query(final ThermostatRequestDto queryRequestDto);
}
