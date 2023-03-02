package com.eronalves.consultafrete.models.response;

import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class EnderecoResponse {

	private String cep;
	private String logradouro;
	private String complemento;
	private String bairro;
	private String localidade;
	private String uf;

	public void checarNulos() throws CepInexistenteException {
		if (cep == null && logradouro == null && complemento == null && bairro == null && localidade == null
				&& uf == null)
			throw new CepInexistenteException("Cep não existe");
	}

	public ConsultaDto toConsultaDto() {
		ConsultaDto consultaDto = new ConsultaDto();
		consultaDto.setCep(cep);
		consultaDto.setBairro(bairro);
		consultaDto.setCidade(localidade);
		consultaDto.setComplemento(complemento);
		consultaDto.setEstado(uf);
		consultaDto.setRua(logradouro);
		return consultaDto;
	}

}
