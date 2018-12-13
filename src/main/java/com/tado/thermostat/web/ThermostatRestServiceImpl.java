package com.tado.thermostat.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tado.thermostat.dto.ThermostatRequestDto;
import com.tado.thermostat.dto.ThermostatResponseDto;
import com.tado.thermostat.service.ThermostatService;

@RestController
public class ThermostatRestServiceImpl implements ThermostatRestService {

	private final ThermostatService thermostatService;
	
	@Autowired
	public ThermostatRestServiceImpl(final ThermostatService thermostatService) {
		this.thermostatService = thermostatService;
	}
	
	@PostMapping(
			path = SYNC_API_PATH,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ThermostatResponseDto thermostat(@RequestBody final ThermostatRequestDto thermostatRequestDto) {
		return thermostatService.thermostat(thermostatRequestDto);
	}
}
