package com.eronalves.consultafrete.models.dto;

public class Endereco {

	public static boolean validaCep(String cep) {
		return cep.matches("[0-9]{8}") || cep.matches("[0-9]{5}-[0-9]{3}");
	}
}
