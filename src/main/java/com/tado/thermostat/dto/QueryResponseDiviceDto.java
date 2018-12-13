package com.tado.thermostat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryResponseDiviceDto implements Serializable {

	private static final long serialVersionUID = -7526406956677539581L;

	private boolean online;
	private String thermostatMode;
	private float thermostatTemperatureSetpoint;
	private float thermostatTemperatureAmbient;
	private float thermostatHumidityAmbient;

	public boolean isOnline() {
		return online;
	}

	public void setOnline(boolean online) {
		this.online = online;
	}

	public String getThermostatMode() {
		return thermostatMode;
	}

	public void setThermostatMode(String thermostatMode) {
		this.thermostatMode = thermostatMode;
	}

	public float getThermostatTemperatureSetpoint() {
		return thermostatTemperatureSetpoint;
	}

	public void setThermostatTemperatureSetpoint(float thermostatTemperatureSetpoint) {
		this.thermostatTemperatureSetpoint = thermostatTemperatureSetpoint;
	}

	public float getThermostatTemperatureAmbient() {
		return thermostatTemperatureAmbient;
	}

	public void setThermostatTemperatureAmbient(float thermostatTemperatureAmbient) {
		this.thermostatTemperatureAmbient = thermostatTemperatureAmbient;
	}

	public float getThermostatHumidityAmbient() {
		return thermostatHumidityAmbient;
	}

	public void setThermostatHumidityAmbient(float thermostatHumidityAmbient) {
		this.thermostatHumidityAmbient = thermostatHumidityAmbient;
	}

}
