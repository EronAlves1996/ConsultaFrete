package com.eronalves.consultafrete.testeautomatizado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;
import com.eronalves.consultafrete.models.response.GenericResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormatoCepTest extends SpringConfig {

	private static final String ENDERECO = "http://localhost:";
	private static final String URI = "/v1/consulta-endereco";

	@LocalServerPort
	int port;

	@Autowired
	RestTemplate restTemplate;

	ResponseEntity response;
	ObjectMapper om = new ObjectMapper();

	@When("o usuario faz uma chamada com CEP {string}")
	public void o_usuario_faz_uma_chamada_com_cep(String cep) {
		final String URL = ENDERECO + port + URI;
		CepRequest cepRequest = new CepRequest(cep);
		response = restTemplate.postForEntity(URL, cepRequest, ConsultaResponse.class);
	}

	@Then("o usuario recebe um status {int}")
	public void o_usuario_recebe_um_status(Integer status) {
		assertEquals(HttpStatus.valueOf(status), response.getStatusCode());
	}

	@Then("o usuario recebe informacoes validas \\(nao nulas)")
	public void o_usuario_recebe_informacoes_validas_nao_nulas() {
		ConsultaResponse resposta = (ConsultaResponse) response.getBody();
		System.out.println(resposta);
		assertNotNull(resposta);
		assertNotNull(resposta.bairro);
		assertNotNull(resposta.cep);
		assertNotNull(resposta.cidade);
		assertNotNull(resposta.complemento);
		assertNotNull(resposta.estado);
		assertNotNull(resposta.frete);
		assertNotNull(resposta.rua);
	}

	@When("o usuario faz uma chamada com CEP invalido {string}")
	public void o_usuario_faz_uma_chamada_com_cep_invalido(String cep) {
		final String URL = ENDERECO + port + URI;
		CepRequest cepRequest = new CepRequest(cep);
		try {
			response = restTemplate.postForEntity(URL, cepRequest, GenericResponse.class);
			System.out.println(response);
		} catch (HttpClientErrorException ex) {
			response = ResponseEntity.status(ex.getStatusCode())
					.body(om.convertValue(ex.getResponseBodyAsString(), GenericResponse.class));
		}
	}

	@Then("com a mensagem {string}")
	public void com_a_mensagem(String string) {
		GenericResponse body = (GenericResponse) response.getBody();
	}

}
