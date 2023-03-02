package com.eronalves.consultafrete.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;

@RestController("v1")
public class ConsultaController {

	@PostMapping("/consulta-endereco")
	public ConsultaResponse consultarFrete(@RequestBody CepRequest cep) {
		return null;
	}
}
