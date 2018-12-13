package com.tado.thermostat.dto;

import java.io.Serializable;

public class AbstractInputDto implements Serializable {

	private static final long serialVersionUID = -8354391758910090687L;
	
	
	private String intent;

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}
}
