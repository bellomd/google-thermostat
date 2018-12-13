package com.tado.thermostat.exception;

public class NotImplementedException extends AbstractRuntimeException {

	private static final long serialVersionUID = -220541913975836272L;

	public NotImplementedException(final String message) {
		super(message);
	}
	
	public NotImplementedException(final Throwable cause) {
		super(cause);
	}
	
	public NotImplementedException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
