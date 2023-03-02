package com.eronalves.consultafrete.exception;

public class ApiTimeoutException extends RuntimeException {

	private static final long serialVersionUID = 5937626174708846524L;

	public ApiTimeoutException(String msg) {
		super(msg);
	}

}
