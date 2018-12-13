package com.tado.thermostat.dto;

public final class TextInterpolator {

	private TextInterpolator() {
	}
	
	public static String interpolate(final String str, final String[] keys, final Long... values) {
		
		String path = str;
		
		for (int i = 0; i < keys.length; i++) {
			path = path.replace(keys[i], String.valueOf(values[i]));
		}
		
		return path;
	}
}
