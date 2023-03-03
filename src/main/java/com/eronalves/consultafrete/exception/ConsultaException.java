package com.eronalves.consultafrete.exception;

/**
 * Erro que é lançado quando o CEP é inválido
 * 
 * @author eronads
 *
 */
public class ConsultaException extends RuntimeException {

	private static final long serialVersionUID = 3302671975998437796L;

	public ConsultaException(String msg) {
		super(msg);
	}
}
