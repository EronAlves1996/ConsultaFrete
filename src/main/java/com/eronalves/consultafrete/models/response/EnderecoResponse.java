package com.eronalves.consultafrete.models.response;

import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class EnderecoResponse {

	public String cep;
	public String logradouro;
	public String complemento;
	public String bairro;
	public String localidade;
	public String uf;

	public void checarNulos() throws CepInexistenteException {
		if (cep == null && logradouro == null && complemento == null && bairro == null && localidade == null
				&& uf == null)
			throw new CepInexistenteException("Cep não existe");
	}

	public ConsultaDto toConsultaDto() {
		ConsultaDto consultaDto = new ConsultaDto();
		consultaDto.cep = cep;
		consultaDto.bairro = bairro;
		consultaDto.cidade = localidade;
		consultaDto.complemento = complemento;
		consultaDto.estado = uf;
		consultaDto.rua = logradouro;
		return consultaDto;
	}

	@Override
	public String toString() {
		return "EnderecoResponse [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}

}
