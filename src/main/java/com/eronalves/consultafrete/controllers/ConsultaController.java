package com.eronalves.consultafrete.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.service.ConsultaService;

@RestController("v1")
public class ConsultaController {

	private ConsultaService consultaService;

	public ConsultaController(ConsultaService consultaService) {
		super();
		this.consultaService = consultaService;
	}

	@PostMapping("/consulta-endereco")
	public ConsultaResponse consultarFrete(@RequestBody CepRequest cep) throws ConsultaException {
		ConsultaDto enderecoDto = cep.toEnderecoDto();
		ConsultaDto consultaFrete = consultaService.consultaFrete(enderecoDto);
		ConsultaResponse consultaResponse = ConsultaResponse.from(consultaFrete);
		return consultaResponse;
	}
}
