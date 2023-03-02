package com.eronalves.consultafrete.testeautomatizado;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormatoCepTest extends SpringConfig {

	@LocalServerPort
	int port;

	@Autowired
	RestTemplate restTemplate;

	ResponseEntity<ConsultaResponse> response;

	@When("^o usuário faz uma chamada com CEP \"010010000\"$")
	public void usuario_faz_chamada() {
		CepRequest cepRequest = new CepRequest("01001000");
		response = restTemplate.postForEntity("http://localhost:" + port + "/v1/consulta-endereco", cepRequest,
				ConsultaResponse.class);
	}

	@Then("^o usuário recebe um status 200$")
	public void usuario_recebe_status_200() {
		assertEquals(200, response.getStatusCode());
	}

	@And("^o usuario recebe informacoes validas (nao nulas)$")
	public void usuario_recebe_informacoes_validas() {
		ConsultaResponse endereco = response.getBody();
		assertNotNull(endereco);
		assertNotNull(endereco.getBairro());
		assertNotNull(endereco.getFrete());
		assertNotNull(endereco.getComplemento());
	}
}
