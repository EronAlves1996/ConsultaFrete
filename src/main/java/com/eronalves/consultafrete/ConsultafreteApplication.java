package com.eronalves.consultafrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * 
 * @author eronads Classe principal que executa a aplicação por inteiro, além de
 *         registrar beans importantes
 */
@SpringBootApplication
@OpenAPIDefinition(servers = {
		@Server(url = "/") }, info = @Info(description = "API de Cálculo de frete através do CEP", title = "Consulta Frete", version = "0.0.1"))
public class ConsultafreteApplication {

	private static final int SEGUNDO = 1000;

	/**
	 * Executa a aplicação
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(ConsultafreteApplication.class, args);
	}

	/**
	 * Cria um novo RestTemplate com timeout de conexão de 2.5s e timeout de leitura
	 * de 1s
	 * 
	 * @return Uma Bean de Rest Template
	 */
	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout((int) 2.5 * SEGUNDO);

		// Read Timeout de 1s
		simpleClientHttpRequestFactory.setReadTimeout(1 * SEGUNDO);

		RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
		return restTemplate;
	}

}
