package com.eronalves.consultafrete.utils;

import java.util.List;

/**
 * Classe de modelo que define uma região, seus estados e o valor de seu frete
 * 
 * @author eronads
 *
 */
public class Regiao {

	private String nome;
	public double frete;
	private List<String> estados;

	public Regiao(String nome, double frete, List<String> estados) {
		super();
		this.nome = nome;
		this.frete = frete;
		this.estados = estados;
	}

	/**
	 * Informa se a região possui determinado estado
	 * 
	 * @param estado
	 * @return
	 */
	public boolean possuiEstado(String estado) {
		return estados.stream().anyMatch(e -> e.contains(estado));
	}

}
