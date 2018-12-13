package com.tado.thermostat.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomDataDto implements Serializable {

	private static final long serialVersionUID = -1573305318669712947L;

	private int fooValue;
	private boolean barValue;
	private String bazValue;

	public int getFooValue() {
		return fooValue;
	}

	public void setFooValue(int fooValue) {
		this.fooValue = fooValue;
	}

	public boolean isBarValue() {
		return barValue;
	}

	public void setBarValue(boolean barValue) {
		this.barValue = barValue;
	}

	public String getBazValue() {
		return bazValue;
	}

	public void setBazValue(String bazValue) {
		this.bazValue = bazValue;
	}
}
