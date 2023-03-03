package com.eronalves.consultafrete.models.request;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

/**
 * Classe de modelo que serve para abrigar a informação de uma request da
 * aplicação
 * 
 * @author eronads
 *
 */
public class CepRequest {

	@NotNull
	@Min(8)
	@Max(9)
	public String cep;

	public CepRequest(String cep) {
		this.cep = cep;
	}

	public CepRequest() {
	}

	/**
	 * Transforma essa classe em um ConsultaDTO
	 * 
	 * @return
	 */
	public ConsultaDto toConsultaDto() {
		ConsultaDto enderecoDto = new ConsultaDto();
		enderecoDto.cep = cep;
		return enderecoDto;
	}

}
