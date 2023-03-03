package com.eronalves.consultafrete.models.response;

import java.util.Objects;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.eronalves.consultafrete.models.dto.ConsultaDto;

public class ConsultaResponse {

	@NotBlank
	public String cep;
	@NotBlank
	public String rua;
	@NotNull
	public String complemento;
	@NotBlank
	public String bairro;
	@NotBlank
	public String cidade;
	@NotBlank
	public String estado;
	@NotBlank
	public Double frete;

	public static ConsultaResponse from(ConsultaDto enderecoDto) {
		ConsultaResponse consultaResponse = new ConsultaResponse();
		consultaResponse.bairro = enderecoDto.bairro;
		consultaResponse.cep = enderecoDto.cep;
		consultaResponse.cidade = enderecoDto.cidade;
		consultaResponse.complemento = enderecoDto.complemento;
		consultaResponse.estado = enderecoDto.estado;
		consultaResponse.frete = enderecoDto.frete;
		consultaResponse.rua = enderecoDto.rua;
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
