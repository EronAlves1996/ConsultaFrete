package com.eronalves.consultafrete.unittest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.eronalves.consultafrete.controllers.ConsultaController;
import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.exception.CepInexistenteException;
import com.eronalves.consultafrete.exception.ConsultaException;
import com.eronalves.consultafrete.models.dto.ConsultaDto;
import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.service.ConsultaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class ConsultaControllerTest {

	private static final String CEP_VALIDO_NAO_EXISTE = "99999999";
	private static final String CEP_COM_CARACTER_INVALIDO = "01021a20";
	private static ConsultaDto enderecoRetornado;
	private static ObjectMapper om = new ObjectMapper();
	private static final String CEP_VALIDO_SEM_MASCARA = "01001000";
	private static final String CEP_VALIDO_COM_MASCARA = "01001-000";

	@BeforeAll
	public static void populaEnderecoRetornado() {
		enderecoRetornado = new ConsultaDto();
		enderecoRetornado.bairro = "Sé";
		enderecoRetornado.cep = "01001-000";
		enderecoRetornado.cidade = "São Paulo";
		enderecoRetornado.complemento = "lado ímpar";
		enderecoRetornado.estado = "SP";
		enderecoRetornado.frete = 7.85;
		enderecoRetornado.rua = "Praça da Sé";
	}

	@Autowired
	ConsultaController consultaController;

	@MockBean
	ConsultaService consultaService;

	@Autowired
	MockMvc mockMvc;

	@Test
	public void enviaCepSemMascara() throws ConsultaException {
		CepRequest cepSemMascara = new CepRequest(CEP_VALIDO_SEM_MASCARA);
		ConsultaDto enderecoDto = cepSemMascara.toConsultaDto();

		when(consultaService.consultaFrete(enderecoDto)).thenReturn(enderecoRetornado);

		ConsultaResponse retornoConsulta = consultaController.consultarFrete(cepSemMascara);

		assertEquals(retornoConsulta, ConsultaResponse.from(enderecoRetornado));
	}

	@Test
	public void enviaCepComMascara() throws ConsultaException {
		CepRequest cepComMascara = new CepRequest(CEP_VALIDO_COM_MASCARA);
		ConsultaDto enderecoDto = cepComMascara.toConsultaDto();
		when(consultaService.consultaFrete(enderecoDto)).thenReturn(enderecoRetornado);

		ConsultaResponse retornoConsulta = consultaController.consultarFrete(cepComMascara);

		assertEquals(retornoConsulta, ConsultaResponse.from(enderecoRetornado));
	}

	@Test
	public void enviaCepInvalido() throws JsonProcessingException, Exception {
		CepRequest cepInvalido = new CepRequest(CEP_COM_CARACTER_INVALIDO);
		ConsultaDto enderecoDto = cepInvalido.toConsultaDto();
		when(consultaService.consultaFrete(enderecoDto)).thenThrow(ConsultaException.class);

		mockMvc.perform(post("/v1/consulta-endereco").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(cepInvalido))).andExpect(status().is(400));
	}

	@Test
	public void apiIndisponivel() throws JsonProcessingException, Exception {
		CepRequest cepComMascara = new CepRequest(CEP_VALIDO_COM_MASCARA);
		ConsultaDto enderecoDto = cepComMascara.toConsultaDto();
		when(consultaService.consultaFrete(enderecoDto)).thenThrow(ApiTimeoutException.class);

		mockMvc.perform(post("/v1/consulta-endereco").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(cepComMascara))).andExpect(status().is(504));
	}

	@Test
	public void cepNaoExiste() throws JsonProcessingException, Exception {
		CepRequest cepComMascara = new CepRequest(CEP_VALIDO_NAO_EXISTE);
		ConsultaDto enderecoDto = cepComMascara.toConsultaDto();
		when(consultaService.consultaFrete(enderecoDto)).thenThrow(CepInexistenteException.class);

		mockMvc.perform(post("/v1/consulta-endereco").contentType(MediaType.APPLICATION_JSON)
				.content(om.writeValueAsString(cepComMascara))).andExpect(status().is(200));
	}

}
