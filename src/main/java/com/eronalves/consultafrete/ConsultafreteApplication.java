package com.eronalves.consultafrete;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsultafreteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultafreteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		SimpleClientHttpRequestFactory simpleClientHttpRequestFactory = new SimpleClientHttpRequestFactory();
		simpleClientHttpRequestFactory.setConnectTimeout(2500);

		// Read Timeout de 1s
		simpleClientHttpRequestFactory.setReadTimeout(1000);

		RestTemplate restTemplate = new RestTemplate(simpleClientHttpRequestFactory);
		return restTemplate;
	}

}
