package com.tado.thermostat.api;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.tado.thermostat.dto.TextInterpolator;

@Component
@ConfigurationProperties("tado.api")
public class TadoApiPath {

	private static final String HOME_PATH_VARIABLE_NAME = "{home_id}";
	private static final String ZONE_PATH_VARIABLE_NAME = "{zone_id}";
	
	private String userInfo;
	private String homeZonesInfo;
	private String zoneState;
	private String overlay;

	public String getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(String userInfo) {
		this.userInfo = userInfo;
	}

	public String getHomeZonesInfo() {
		return homeZonesInfo;
	}
	
	public String getHomeZonesInfo(final Long homeId) {
		final String path = TextInterpolator.interpolate(
				homeZonesInfo, 
				new String[] {HOME_PATH_VARIABLE_NAME},
				homeId);
		
		return path;
	}

	public void setHomeZonesInfo(String homeZonesInfo) {
		this.homeZonesInfo = homeZonesInfo;
	}

	public String getZoneStateUri() {
		return zoneState;
	}
	
	public String getZoneState(final Long homeId, final Long zoneId) {
		final String path = TextInterpolator.interpolate(zoneState, 
				new String[] {HOME_PATH_VARIABLE_NAME, ZONE_PATH_VARIABLE_NAME},  
				homeId, zoneId);
		
		return path;
	}

	public void setZoneState(String zoneState) {
		this.zoneState = zoneState;
	}

	public String getOverlay() {
		return overlay;
	}
	
	public String getOverlay(final Long homeId, final Long zoneId) {
		final String path = TextInterpolator.interpolate(overlay, 
				new String[] {HOME_PATH_VARIABLE_NAME, ZONE_PATH_VARIABLE_NAME},  
				homeId, zoneId);
		
		return path;
	}

	public void setOverlay(String overlay) {
		this.overlay = overlay;
	}
}
