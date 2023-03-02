package com.eronalves.consultafrete.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.response.APIResponse;
import com.eronalves.consultafrete.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	@Autowired
	RestTemplate restTemplate;

	private final Map<String, String> tabelaEstadoRegiao = new HashMap<>();

	{
		tabelaEstadoRegiao.put("MG", "Sudeste");
		tabelaEstadoRegiao.put("SP", "Sudeste");
		tabelaEstadoRegiao.put("RJ", "Sudeste");
		tabelaEstadoRegiao.put("ES", "Sudeste");
		tabelaEstadoRegiao.put("DF", "Centro-Oeste");
		tabelaEstadoRegiao.put("GO", "Centro-Oeste");
		tabelaEstadoRegiao.put("MS", "Centro-Oeste");
		tabelaEstadoRegiao.put("MT", "Centro-Oeste");
		tabelaEstadoRegiao.put("MA", "Nordeste");
		tabelaEstadoRegiao.put("PI", "Nordeste");
		tabelaEstadoRegiao.put("RN", "Nordeste");
		tabelaEstadoRegiao.put("CE", "Nordeste");
		tabelaEstadoRegiao.put("PB", "Nordeste");
		tabelaEstadoRegiao.put("BA", "Nordeste");
		tabelaEstadoRegiao.put("PB", "Nordeste");
		tabelaEstadoRegiao.put("AL", "Nordeste");
		tabelaEstadoRegiao.put("SE", "Nordeste");
		tabelaEstadoRegiao.put("SC", "Sul");
		tabelaEstadoRegiao.put("AM", "Norte");
		tabelaEstadoRegiao.put("AC", "Norte");
		tabelaEstadoRegiao.put("RO", "Norte");
		tabelaEstadoRegiao.put("RR", "Norte");
		tabelaEstadoRegiao.put("AP", "Norte");
		tabelaEstadoRegiao.put("PA", "Norte");
		tabelaEstadoRegiao.put("TO", "Norte");
	}

	private static boolean validaCep(String cep) {
		return cep.matches("[0-9]{8}") || cep.matches("[0-9]{5}-[0-9]{3}");
	}

	@Override
	public ConsultaDto consultaFrete(ConsultaDto dto) throws ConsultaException {
		if (!validaCep(dto.getCep()))
			throw new ConsultaException("CEP não é válido");
		ResponseEntity<APIResponse> enderecoResponse = restTemplate
				.getForEntity(String.format("http://viacep.com.br/ws/%s/json/", dto.getCep()), APIResponse.class);
		APIResponse endereco = enderecoResponse.getBody();

	}

}
