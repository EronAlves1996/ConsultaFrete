package com.eronalves.consultafrete.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.response.APIResponse;
import com.eronalves.consultafrete.service.ConsultaService;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	RestTemplate restTemplate = new RestTemplate();

	private final Map<String, String> tabelaEstadoRegiao = new HashMap<>();
	private final Map<String, Double> tabelaFrete = new HashMap<>();

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
		tabelaEstadoRegiao.put("PR", "Sul");
		tabelaEstadoRegiao.put("RS", "Sul");
		tabelaEstadoRegiao.put("AM", "Norte");
		tabelaEstadoRegiao.put("AC", "Norte");
		tabelaEstadoRegiao.put("RO", "Norte");
		tabelaEstadoRegiao.put("RR", "Norte");
		tabelaEstadoRegiao.put("AP", "Norte");
		tabelaEstadoRegiao.put("PA", "Norte");
		tabelaEstadoRegiao.put("TO", "Norte");
		tabelaFrete.put("Sudeste", 7.85);
		tabelaFrete.put("Centro-Oeste", 12.5);
		tabelaFrete.put("Nordeste", 15.98);
		tabelaFrete.put("Sul", 17.3);
		tabelaFrete.put("Norte", 20.83);
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
		ConsultaDto returnValue = new ConsultaDto();
		BeanUtils.copyProperties(endereco, returnValue);
		returnValue.setRua(endereco.getLogradouro());
		returnValue.setCidade(endereco.getLocalidade());
		returnValue.setEstado(endereco.getUf());
		returnValue.setFrete(tabelaFrete.get(tabelaEstadoRegiao.get(endereco.getUf())));
		System.out.println(returnValue.getFrete());
		return returnValue;
	}

}
