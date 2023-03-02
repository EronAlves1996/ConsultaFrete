package com.eronalves.consultafrete;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.eronalves.consultafrete.controllers.ConsultaController;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.service.ConsultaService;

@SpringBootTest
public class ConsultaControllerTest {

	private static ConsultaDto enderecoRetornado;

	@BeforeAll
	public static void populaEnderecoRetornado() {
		enderecoRetornado = new ConsultaDto();
		enderecoRetornado.setBairro("Sé");
		enderecoRetornado.setCep("01001-000");
		enderecoRetornado.setCidade("São Paulo");
		enderecoRetornado.setComplemento("lado ímpar");
		enderecoRetornado.setEstado("SP");
		enderecoRetornado.setFrete(7.85);
		enderecoRetornado.setRua("Praça da Sé");
	}

	@Autowired
	ConsultaController consultaController;

	@MockBean
	ConsultaService consultaService;

	@Test
	public void enviaCepSemMascara() throws ConsultaException {
		CepRequest cepSemMascara = new CepRequest("01001000");
		ConsultaDto enderecoDto = cepSemMascara.toEnderecoDto();

		when(consultaService.consultaFrete(enderecoDto)).thenReturn(enderecoRetornado);

		ConsultaResponse retornoConsulta = consultaController.consultarFrete(cepSemMascara);

		assertEquals(retornoConsulta, ConsultaResponse.from(enderecoRetornado));
	}

	@Test
	public void enviaCepComMascara() throws ConsultaException {
		CepRequest cepComMascara = new CepRequest("01001-000");
		ConsultaDto enderecoDto = cepComMascara.toEnderecoDto();
		when(consultaService.consultaFrete(enderecoDto)).thenReturn(enderecoRetornado);

		ConsultaResponse retornoConsulta = consultaController.consultarFrete(cepComMascara);

		assertEquals(retornoConsulta, ConsultaResponse.from(enderecoRetornado));
	}

}
