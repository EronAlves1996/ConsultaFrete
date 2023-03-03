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

import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestControllerAdvice
public class ConsultaControllerAdvice {

	@ExceptionHandler(ConsultaException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ApiResponse(responseCode = "400", description = "A aplicação retorna um erro ao tentar realizar uma consulta com um CEP inválido ou mal formatado")
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ConsultaException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.badRequest().body(mensagemErro);
	}

	@ExceptionHandler(ApiTimeoutException.class)
	@ResponseStatus(code = HttpStatus.GATEWAY_TIMEOUT)
	@ApiResponse(responseCode = "504", description = "Caso o serviço de consulta de CEP esteja indisponível, a aplicação irá retornar um erro")
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(ApiTimeoutException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.status(HttpStatus.GATEWAY_TIMEOUT).body(mensagemErro);
	}

	@ExceptionHandler(CepInexistenteException.class)
	@ResponseStatus(code = HttpStatus.OK)
	@ApiResponse(responseCode = "200", description = "A aplicação pode estar funcionando e o CEP fornecido pode ser válido, porém o CEP pode não existir. Nesse caso a aplicação retorna tudo OK, informando que o CEP não existe")
	public ResponseEntity<GenericResponse> retornaMensagemDeErro(CepInexistenteException ex) {
		GenericResponse mensagemErro = new GenericResponse(ex.getMessage());
		return ResponseEntity.ok().body(mensagemErro);
	}

}
