package com.eronalves.consultafrete.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.service.ConsultaService;

@RestController
@RequestMapping("/v1")
public class ConsultaController {

	@Autowired
	private ConsultaService consultaService;

	@PostMapping("/consulta-endereco")
	public ConsultaResponse consultarFrete(@RequestBody CepRequest cep) throws ConsultaException, ApiTimeoutException {
		ConsultaDto enderecoDto = cep.toEnderecoDto();
		ConsultaDto consultaFrete = consultaService.consultaFrete(enderecoDto);
		ConsultaResponse consultaResponse = ConsultaResponse.from(consultaFrete);
		return consultaResponse;
	}

}
