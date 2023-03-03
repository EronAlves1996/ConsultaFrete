package com.eronalves.consultafrete.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Classe de ajuda que irá abrigar a table de fretes por região
 * 
 * @author eronads
 *
 */
public class TabelaFreteRegiao {

	private List<Regiao> regioes;

	public TabelaFreteRegiao() {
		regioes = new ArrayList<>();
		regioes.add(new Regiao("Sudeste", 7.85, List.of("SP", "MG", "ES", "RJ")));
		regioes.add(new Regiao("Centro-Oeste", 12.5, List.of("DF", "GO", "MS", "MT")));
		regioes.add(new Regiao("Nordeste", 15.98, List.of("MA", "PI", "RN", "CE", "PB", "BA", "AL", "SE", "PE")));
		regioes.add(new Regiao("Sul", 17.3, List.of("SC", "PR", "RS")));
		regioes.add(new Regiao("Norte", 20.83, List.of("AM", "AC", "RO", "RR", "AP", "PA", "TO")));
	}

	/**
	 * Calcula o frete baseado em determinado estado
	 * 
	 * @param estado
	 * @return valor de frete
	 */
	public double calculaFrete(String estado) {
		Optional<Regiao> regiao = regioes.stream().filter(r -> r.possuiEstado(estado)).findFirst();
		return regiao.get().frete;
	}
}
