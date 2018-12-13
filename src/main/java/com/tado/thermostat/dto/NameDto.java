package com.tado.thermostat.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NameDto implements Serializable {

	private static final long serialVersionUID = -7741345172428670904L;

	private List<String> defaultNames;
	private String name;
	private List<String> nicknames;

	public List<String> getDefaultNames() {
		return defaultNames;
	}

	public void setDefaultNames(List<String> defaultNames) {
		this.defaultNames = defaultNames;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getNicknames() {
		return nicknames;
	}

	public void setNicknames(List<String> nicknames) {
		this.nicknames = nicknames;
	}
}
