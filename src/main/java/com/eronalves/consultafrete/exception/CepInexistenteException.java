package com.eronalves.consultafrete.exception;

/**
 * Erro que é lançado quando o CEP não existe
 * 
 * @author eronads
 *
 */
public class CepInexistenteException extends RuntimeException {

	private static final long serialVersionUID = -3634606744625816035L;

	public CepInexistenteException(String msg) {
		super(msg);
	}
}
