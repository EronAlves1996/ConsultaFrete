package com.eronalves.consultafrete.models.request;

import org.springframework.beans.BeanUtils;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class CepRequest {

	private String cep;

	public CepRequest(String cep) {
		this.cep = cep;
	}

	public CepRequest() {
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public ConsultaDto toEnderecoDto() {
		ConsultaDto enderecoDto = new ConsultaDto();
		BeanUtils.copyProperties(this, enderecoDto);
		return enderecoDto;
	}

}
