package com.eronalves.consultafrete.controllers.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.response.GenericResponse;

@RestControllerAdvice
public class ConsultaControllerAdvice {

	@ExceptionHandler(ConsultaException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ConsultaException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.badRequest().body(mensagemErro);
	}

	@ExceptionHandler(ApiTimeoutException.class)
	@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT)
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ApiTimeoutException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(mensagemErro);
	}

}
