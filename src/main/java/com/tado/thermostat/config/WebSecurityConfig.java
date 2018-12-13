package com.tado.thermostat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;

import com.tado.thermostat.auth.Auth2TokenProvider;
import com.tado.thermostat.auth.ThermostatTokenFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private final Auth2TokenProvider auth2TokenProvider;
	
	@Autowired
	public WebSecurityConfig(final Auth2TokenProvider auth2TokenProvider) {
		this.auth2TokenProvider = auth2TokenProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(auth2TokenProvider);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/public/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//@formatter:off
		http
			.exceptionHandling()
			.authenticationEntryPoint(new Http403ForbiddenEntryPoint())
			.and()
			.csrf()
			.disable()
			.headers()
			.frameOptions()
			.disable()
			.and()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.authorizeRequests()
				.antMatchers("/thermostat/admin/**").hasAnyRole("ADMIN")
				.antMatchers("/thermostat/**").authenticated()
			.and()
			.addFilter(new ThermostatTokenFilter(authenticationManager()));
		//@formatter:on
	}
}
