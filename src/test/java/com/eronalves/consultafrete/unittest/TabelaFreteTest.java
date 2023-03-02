package com.eronalves.consultafrete.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.boot.test.context.SpringBootTest;

import com.eronalves.consultafrete.utils.TabelaFreteRegiao;

@SpringBootTest
public class TabelaFreteTest {

	private TabelaFreteRegiao tabela = new TabelaFreteRegiao();

	@ParameterizedTest
	@MethodSource("fretesEstado")
	public void testaFretes(String estado, double frete) {
		double freteCalculado = tabela.calculaFrete(estado);
		assertEquals(frete, freteCalculado);
	}

	private static Stream<Arguments> fretesEstado() {
		final double FRETE_SUDESTE = 7.85;
		final double FRETE_CENTRO_OESTE = 12.50;
		final double FRETE_NORDESTE = 15.98;
		final double FRETE_SUL = 17.3;
		final double FRETE_NORTE = 20.83;

		return Stream.of(arguments("MG", FRETE_SUDESTE), arguments("SP", FRETE_SUDESTE), arguments("ES", FRETE_SUDESTE),
				arguments("RJ", FRETE_SUDESTE), arguments("DF", FRETE_CENTRO_OESTE),
				arguments("GO", FRETE_CENTRO_OESTE), arguments("MS", FRETE_CENTRO_OESTE),
				arguments("MT", FRETE_CENTRO_OESTE), arguments("MA", FRETE_NORDESTE), arguments("PI", FRETE_NORDESTE),
				arguments("RN", FRETE_NORDESTE), arguments("CE", FRETE_NORDESTE), arguments("PB", FRETE_NORDESTE),
				arguments("BA", FRETE_NORDESTE), arguments("PE", FRETE_NORDESTE), arguments("AL", FRETE_NORDESTE),
				arguments("SE", FRETE_NORDESTE), arguments("SC", FRETE_SUL), arguments("PR", FRETE_SUL),
				arguments("RS", FRETE_SUL), arguments("AM", FRETE_NORTE), arguments("AC", FRETE_NORTE),
				arguments("RO", FRETE_NORTE), arguments("RR", FRETE_NORTE), arguments("AP", FRETE_NORTE),
				arguments("PA", FRETE_NORTE), arguments("TO", FRETE_NORTE));
	}

	private static Arguments arguments(String estado, double frete) {
		return Arguments.of(estado, frete);
	}

}
