package com.eronalves.consultafrete.testeautomatizado;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.models.request.CepRequest;
import com.eronalves.consultafrete.models.response.ConsultaResponse;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TratamentoErroTeste extends SpringConfig {

	private static final String endereco = "http://localhost:";
	private static final String URI = "/v1/consulta-endereco";

	@LocalServerPort
	int port;

	@MockBean
	RestTemplate restTemplate;

	ResponseEntity response;

	@When("o usuario faz uma chamada com CEP {string} e API está indisponível")
	public void o_usuario_faz_uma_chamada_com_cep_e_api_está_indisponível(String cep) {
		when(restTemplate.postForEntity(null, cep, null))
		
		CepRequest cepRequest = new CepRequest(cep);
		response = restTemplate.postForEntity(endereco + port + URI, cepRequest,
				ConsultaResponse.class);
	}

	@Then("o usuario espera por volta de {int} segundos")
	public void o_usuario_espera_por_volta_de_segundos(Integer segundos) throws InterruptedException {
		Thread.sleep(segundos * 1000);
	}

	@When("o usuario faz uma chamada com CEP inválido {string}")
	public void o_usuario_faz_uma_chamada_com_cep_inválido(String string) {
		// Write code here that turns the phrase above into concrete actions
		throw new io.cucumber.java.PendingException();
	}

}
