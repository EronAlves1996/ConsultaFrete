package com.eronalves.consultafrete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.service.ConsultaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/v1")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@Operation(summary = "Consulta um endereço e valor de frete por meio do CEP", method = "POST")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Consulta um endereço e calcula o valor do frete para o mesmo"),
			@ApiResponse(responseCode = "400", description = "CEP invalido ou mal formatado"),
			@ApiResponse(responseCode = "504", description = "Serviço de consulta CEP indisponível, tente novamente mais tarde"),
			@ApiResponse(responseCode = "200", description = "O CEP informado não existe") })
	@PostMapping(value = "/consulta-endereco", produces = "application/json", consumes = "application/json")
	public ConsultaResponse consultarFrete(@RequestBody CepRequest cep)
			throws ConsultaException, ApiTimeoutException, CepInexistenteException {
		ConsultaDto enderecoDto = cep.toEnderecoDto();
		ConsultaDto consultaFrete = consultaService.consultaFrete(enderecoDto);
		ConsultaResponse consultaResponse = ConsultaResponse.from(consultaFrete);
		return consultaResponse;
	}

}
