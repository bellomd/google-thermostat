package com.tado.thermostat.dto;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceDto implements Serializable {

	private static final long serialVersionUID = -2960416631314733690L;

	private String id;
	private String type;
	private List<String> traits;
	private NameDto name;
	private boolean willReportState;
	private AttributeDto attributes;
	private DeviceInfoDto deviceInfo;
	private CustomDataDto customData;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<String> getTraits() {
		return traits;
	}

	public void setTraits(List<String> traits) {
		this.traits = traits;
	}

	public NameDto getName() {
		return name;
	}

	public void setName(NameDto name) {
		this.name = name;
	}

	public boolean isWillReportState() {
		return willReportState;
	}

	public void setWillReportState(boolean willReportState) {
		this.willReportState = willReportState;
	}

	public AttributeDto getAttributes() {
		return attributes;
	}

	public void setAttributes(AttributeDto attributes) {
		this.attributes = attributes;
	}

	public DeviceInfoDto getDeviceInfo() {
		return deviceInfo;
	}

	public void setDeviceInfo(DeviceInfoDto deviceInfo) {
		this.deviceInfo = deviceInfo;
	}

	public CustomDataDto getCustomData() {
		return customData;
	}

	public void setCustomData(CustomDataDto customData) {
		this.customData = customData;
	}
}
