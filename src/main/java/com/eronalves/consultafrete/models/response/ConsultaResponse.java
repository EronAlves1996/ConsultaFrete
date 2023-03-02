package com.eronalves.consultafrete.models.response;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class ConsultaResponse {

	private String cep;
	private String rua;
	private String complemento;
	private String bairro;
	private String cidade;
	private String estado;
	private Double frete;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getFrete() {
		return frete;
	}

	public void setFrete(Double frete) {
		this.frete = frete;
	}

	public static ConsultaResponse from(ConsultaDto enderecoDto) {
		ConsultaResponse consultaResponse = new ConsultaResponse();
		BeanUtils.copyProperties(enderecoDto, consultaResponse);
		return consultaResponse;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, complemento, estado, frete, rua);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaResponse other = (ConsultaResponse) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(frete, other.frete)
				&& Objects.equals(rua, other.rua);
	}

}
