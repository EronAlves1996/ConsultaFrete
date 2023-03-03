package com.eronalves.consultafrete.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.response.GenericResponse;

/**
 * Define retornos específicos quando ocorre algum erro na aplicação
 * 
 * @author eronads
 *
 */
@RestControllerAdvice
public class ConsultaControllerAdvice {

	/**
	 * Retorna uma mensagem de erro quando o CEP é inválido
	 * 
	 * @param ex Erro de consulta
	 * @return uma mensagem de erro em um ResponseEntity
	 */
	@ExceptionHandler(ConsultaException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ConsultaException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.badRequest().body(mensagemErro);
	}

	/**
	 * Retorna uma mensagem de erro quando o serviço de consulta ao CEP está
	 * indisponível
	 * 
	 * @param ex Erro de Timeout do serviço
	 * @return Uma mensagem de erro em um ResponseEntity
	 */
	@ExceptionHandler(ApiTimeoutException.class)
	@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT)
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ApiTimeoutException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(mensagemErro);
	}

	/**
	 * Retorna uma mensagem de erro quando o CEP não existe
	 * 
	 * @param ex Erro de Cep Inexistente
	 * @return Uma mensamge de erro em um ResponseEntity
	 */
	@ExceptionHandler(CepInexistenteException.class)
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(CepInexistenteException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.ok().body(mensagemErro);
	}

}
