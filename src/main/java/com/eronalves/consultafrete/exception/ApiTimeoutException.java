package com.eronalves.consultafrete.exception;

/**
 * Erro que é lançado quando o serviço de consulta ao CEP está indisponível
 * 
 * @author eronads
 *
 */
public class ApiTimeoutException extends RuntimeException {

	private static final long serialVersionUID = 5937626174708846524L;

	public ApiTimeoutException(String msg) {
		super(msg);
	}

}
