package com.eronalves.consultafrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsultafreteApplication {

	private static final int SEGUNDO = 1000;

	public static void main(String[] args) {
		SpringApplication.run(ConsultafreteApplication.class, args);
	}

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
