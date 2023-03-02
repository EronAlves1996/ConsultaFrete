package com.eronalves.consultafrete.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.response.EnderecoResponse;
import com.eronalves.consultafrete.service.ConsultaService;
import com.eronalves.consultafrete.utils.RequestUtil;
import com.eronalves.consultafrete.utils.TabelaFreteRegiao;

@Service
public class ConsultaServiceImpl implements ConsultaService {

	private RequestUtil requestUtil;
	private TabelaFreteRegiao tabela;

	public ConsultaServiceImpl(RequestUtil requestUtil) {
		super();
		this.requestUtil = requestUtil;
		tabela = new TabelaFreteRegiao();
	}

	private static boolean validaCep(String cep) {
		return cep.matches("[0-9]{8}") || cep.matches("[0-9]{5}-[0-9]{3}");
	}

	@Override
	public ConsultaDto consultaFrete(ConsultaDto dto)
			throws ConsultaException, ApiTimeoutException, CepInexistenteException {

		if (!validaCep(dto.getCep()))
			throw new ConsultaException("CEP não é válido");

		String url = String.format("http://viacep.com.br/ws/%s/json/", dto.getCep());
		ResponseEntity<EnderecoResponse> response = requestUtil.requisitarGet(url, EnderecoResponse.class);
		EnderecoResponse endereco = response.getBody();

		endereco.checarNulos();

		ConsultaDto dtoARetornar = endereco.toConsultaDto();
		double frete = tabela.calculaFrete(dtoARetornar.getEstado());
		dtoARetornar.setFrete(frete);

		return dtoARetornar;
	}

}
