package com.eronalves.consultafrete.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.dto.Endereco;
import com.eronalves.consultafrete.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	RestTemplate restTemplate;

	@Override
	public ConsultaDto consultaFrete(ConsultaDto dto) {
		if (!Endereco.validaCep(dto.getCep())) {

		}
	}

}
