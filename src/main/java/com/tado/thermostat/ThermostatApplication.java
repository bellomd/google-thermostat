package com.tado.thermostat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication(scanBasePackages = ThermostatApplication.BASE_PACKAGES)
public class ThermostatApplication extends SpringBootServletInitializer {
	
	static final String BASE_PACKAGES = "com.tado.thermostat";

	public static void main(String[] args) {
		SpringApplication.run(ThermostatApplication.class, args);
	}
}
