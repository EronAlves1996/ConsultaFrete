package com.eronalves.consultafrete.models.request;

import org.springframework.beans.BeanUtils;

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
		BeanUtils.copyProperties(this, enderecoDto);
		return enderecoDto;
	}

}
