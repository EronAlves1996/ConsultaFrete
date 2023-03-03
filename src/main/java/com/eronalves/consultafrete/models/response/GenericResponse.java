package com.eronalves.consultafrete.models.response;

/**
 * Classe de ajuda para fornecer mensagem de resposta quando a aplicação
 * responde com um erro
 * 
 * @author eronads
 *
 */
public class GenericResponse {

	public String mensagem;

	public GenericResponse(String menssagem) {
		this.mensagem = menssagem;
	}

	public GenericResponse() {
	}

}
