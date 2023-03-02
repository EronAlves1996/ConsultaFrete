package com.eronalves.consultafrete.testeautomatizado;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FormatoCepTest extends SpringConfig {

	@LocalServerPort
	int port;

	@Autowired
	RestTemplate restTemplate;

	ResponseEntity<ConsultaResponse> response;

	@When("o usuario faz uma chamada com CEP {string}")
	public void o_usuario_faz_uma_chamada_com_cep(String cep) {
		CepRequest cepRequest = new CepRequest(cep);
		response = restTemplate.postForEntity("http://localhost:" + port + "/v1/consulta-endereco", cepRequest,
				ConsultaResponse.class);
	}

	@Then("o usuario recebe um status {int}")
	public void o_usuario_recebe_um_status(Integer status) {
		assertEquals(HttpStatus.valueOf(status), response.getStatusCode());
	}

	@Then("o usuario recebe informacoes validas \\(nao nulas)")
	public void o_usuario_recebe_informacoes_validas_nao_nulas() {
		ConsultaResponse resposta = response.getBody();
		System.out.println(resposta);
		assertNotNull(resposta);
		assertNotNull(resposta.getBairro());
	}

}
