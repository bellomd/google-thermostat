package com.tado.thermostat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AttributeDto implements Serializable {

	private static final long serialVersionUID = 7298928428454223561L;

	private String availableThermostatModes;
	private char thermostatTemperatureUnit;

	public String getAvailableThermostatModes() {
		return availableThermostatModes;
	}

	public void setAvailableThermostatModes(String availableThermostatModes) {
		this.availableThermostatModes = availableThermostatModes;
	}

	public char getThermostatTemperatureUnit() {
		return thermostatTemperatureUnit;
	}

	public void setThermostatTemperatureUnit(char thermostatTemperatureUnit) {
		this.thermostatTemperatureUnit = thermostatTemperatureUnit;
	}
}
