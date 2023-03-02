package com.eronalves.consultafrete.models.dto;

import java.util.Objects;

public class ConsultaDto {

	public String cep;
	public String rua;
	public String complemento;
	public String bairro;
	public String cidade;
	public String estado;
	public Double frete;

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
		ConsultaDto other = (ConsultaDto) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(complemento, other.complemento)
				&& Objects.equals(estado, other.estado) && Objects.equals(frete, other.frete)
				&& Objects.equals(rua, other.rua);
	}

}
