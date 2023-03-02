package com.eronalves.consultafrete.utils;

import java.util.List;

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

	public boolean possuiEstado(String estado) {
		return estados.stream().anyMatch(e -> e.contains(estado));
	}

}
