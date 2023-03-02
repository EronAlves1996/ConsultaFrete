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

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

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

	@Override
	public String toString() {
		return "EnderecoResponse [cep=" + cep + ", logradouro=" + logradouro + ", complemento=" + complemento
				+ ", bairro=" + bairro + ", localidade=" + localidade + ", uf=" + uf + "]";
	}

}
