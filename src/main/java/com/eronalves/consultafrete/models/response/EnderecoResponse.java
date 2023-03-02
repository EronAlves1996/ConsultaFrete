package com.eronalves.consultafrete.models.response;

import com.eronalves.consultafrete.exception.CepInexistenteException;

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

}
