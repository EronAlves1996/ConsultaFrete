package com.eronalves.consultafrete.models.request;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class CepRequest {

	public String cep;

	public CepRequest(String cep) {
		this.cep = cep;
	}

	public CepRequest() {
	}

	public ConsultaDto toEnderecoDto() {
		ConsultaDto enderecoDto = new ConsultaDto();
		enderecoDto.cep = cep;
		return enderecoDto;
	}

}
