package com.eronalves.consultafrete.models.response;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class ConsultaResponse {

	public String cep;
	public String rua;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	public Double frete;

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

	@Override
	public String toString() {
		return "ConsultaResponse [cep=" + cep + ", rua=" + rua + ", complemento=" + complemento + ", bairro=" + bairro
				+ ", cidade=" + cidade + ", estado=" + estado + ", frete=" + frete + "]";
	}

}
