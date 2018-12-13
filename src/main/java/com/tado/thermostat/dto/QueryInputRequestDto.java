package com.tado.thermostat.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryInputRequestDto extends AbstractInputDto {

	private static final long serialVersionUID = -6791824985626426132L;

	private String intent;
	private QueryPayloadDto payload;

	public String getIntent() {
		return intent;
	}

	public void setIntent(String intent) {
		this.intent = intent;
	}

	public QueryPayloadDto getPayload() {
		return payload;
	}

	public void setPayload(QueryPayloadDto payload) {
		this.payload = payload;
	}
}
