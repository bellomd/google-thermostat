package com.tado.thermostat.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.stereotype.Service;

import com.tado.thermostat.api.TadoApiPath;
import com.tado.thermostat.config.ApiTemplate;
import com.tado.thermostat.dto.AttributeDto;
import com.tado.thermostat.dto.CustomDataDto;
import com.tado.thermostat.dto.DeviceDto;
import com.tado.thermostat.dto.DeviceInfoDto;
import com.tado.thermostat.dto.Intent;
import com.tado.thermostat.dto.NameDto;
import com.tado.thermostat.dto.PayloadDto;
import com.tado.thermostat.dto.QueryResponseDiviceDto;
import com.tado.thermostat.dto.QueryResponseDto;
import com.tado.thermostat.dto.QueryResponsePayloadDto;
import com.tado.thermostat.dto.SyncResponseDto;
import com.tado.thermostat.dto.ThermostatRequestDto;
import com.tado.thermostat.dto.ThermostatResponseDto;
import com.tado.thermostat.exception.NotImplementedException;

@Service
@SuppressWarnings("unused")
public class ThermostatServiceImpl implements ThermostatService{
	
	private final TadoApiPath tadoApiPath;
	private final ApiTemplate restTemplate;
	
	@Autowired
	public ThermostatServiceImpl(final ApiTemplate restTemplate, final TadoApiPath tadoApiPath) {
		this.restTemplate = restTemplate;
		this.tadoApiPath = tadoApiPath;
	}

	public ThermostatResponseDto thermostat(ThermostatRequestDto thermostatRequestDto) {

		final String intent = thermostatRequestDto.getInputs().get(0).getIntent();
		
		if (Intent.SYNC.equals(getIntentSufix(intent))) {
			
			return sync(thermostatRequestDto);
			
		} else if (Intent.QUERY.equals(getIntentSufix(intent)))  {
			
			return query(thermostatRequestDto);
		}
		
		throw new NotImplementedException("The operation is not implemented.");
	}

	public ThermostatResponseDto sync(ThermostatRequestDto syncRequestDto) {
		
		//final String userPath = tadoApiPath.getUserInfo();
		//final OAuth2RestTemplate template = restTemplate.getTemplate();
		
		// Using the rest template call tado api.
		// First get the login user information, such as homes
		/*final UserDto userDto = Optional.of(template.getForObject(tadoApiPath.getUserInfo(), 
				UserDto.class))
				.orElseThrow(() -> new UserInfoException("Cannot retrieve user information."));*/
		
		// Now get the home information
		//final String homePath = tadoApiPath.getHomeZonesInfo(Long.valueOf(userDto.getHomes().get(0).getId()));
		
		/*final ResponseEntity<List<ZoneDto>> response = template.exchange(
				homePath, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<ZoneDto>>(){});
		final List<ZoneDto> zones = response.getBody();*/
		
		// finally using mapper to map all the result to google response.
		// which will be implemented soon.
		
		return getSyncResponseDto();
	}

	public ThermostatResponseDto query(ThermostatRequestDto queryRequestDto) {
		
		// This section will handle the google device query 
		return getQueryResponseDto();
	}
	
	private String getIntentSufix(final String intent) {
		return intent.substring(intent.lastIndexOf('.')+1, intent.length());
	}
	
	private QueryResponseDto getQueryResponseDto() {
		
		final QueryResponseDto queryResponseDto = new QueryResponseDto();
		queryResponseDto.setRequestId("ff36a3cc-ec34-11e6-b1a0-64510650abcf");
		
		
		final QueryResponsePayloadDto queryResponsePayloadDto = new QueryResponsePayloadDto();
		
		final QueryResponseDiviceDto queryResponseDiviceDto = new QueryResponseDiviceDto();
		queryResponseDiviceDto.setOnline(true);
		queryResponseDiviceDto.setThermostatMode("cool");
		queryResponseDiviceDto.setThermostatTemperatureSetpoint(23.0F);
		queryResponseDiviceDto.setThermostatTemperatureAmbient(25.1F);
		queryResponseDiviceDto.setThermostatHumidityAmbient(45.3F);
		
		final Map<String, QueryResponseDiviceDto> devices = new HashMap<String, QueryResponseDiviceDto>();
		devices.put("123", queryResponseDiviceDto);
		
		queryResponsePayloadDto.setDevices(devices);
		
		queryResponseDto.setPayload(queryResponsePayloadDto);
		
		return queryResponseDto;
	}
	
	private SyncResponseDto getSyncResponseDto() {
		
		final SyncResponseDto resonseDto = new SyncResponseDto();
		resonseDto.setRequestId("ff36a3cc-ec34-11e6-b1a0-64510650abcf");
		
		final PayloadDto payloadDto = new PayloadDto();
		payloadDto.setAgentUserId("1836.15267389");
		
		final DeviceDto deviceDto = new DeviceDto();
		deviceDto.setId("123");
		deviceDto.setType("action.devices.types.THERMOSTAT");
		deviceDto.setTraits(Collections.singletonList("action.devices.traits.TemperatureSetting"));
		
		final NameDto name = new NameDto();
		name.setDefaultNames(Collections.singletonList("Honeywell Thermostat T-1000"));
		name.setName("Homer Simpson Thermostat");
		name.setNicknames(Collections.singletonList("living room thermostat"));
		
		deviceDto.setName(name);
		deviceDto.setWillReportState(false);
		
		final AttributeDto attributeDto = new AttributeDto();
		attributeDto.setAvailableThermostatModes("off,heat,cool,on");
		attributeDto.setThermostatTemperatureUnit('F');
		
		deviceDto.setAttributes(attributeDto);
		
		final DeviceInfoDto deviceInfoDto = new DeviceInfoDto();
		deviceInfoDto.setManufacturer("honeywell");
		deviceInfoDto.setModel("t-1000");
		deviceInfoDto.setHwVersion("3.2");
		deviceInfoDto.setSwVersion("11.4");
		
		deviceDto.setDeviceInfo(deviceInfoDto);
		
		final CustomDataDto customDataDto = new CustomDataDto();
		customDataDto.setFooValue(74);
		customDataDto.setBarValue(true);
		customDataDto.setBazValue("lambtwirl");
		
		deviceDto.setCustomData(customDataDto);
		
		payloadDto.setDevices(Collections.singletonList(deviceDto));
		
		resonseDto.setPayload(payloadDto);
		
		return resonseDto;
	}
}
