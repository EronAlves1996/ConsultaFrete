package com.eronalves.consultafrete.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.exception.ApiTimeoutException;

@Component
public class RequestUtil {

	@Autowired
	private RestTemplate restTemplate;

	public <T> ResponseEntity<T> requisitarGet(String url, Class<T> clazz) throws ApiTimeoutException {
		return requisitarGet(url, clazz, 0);
	}

	private <T> ResponseEntity<T> requisitarGet(String url, Class<T> clazz, int tentativas) throws ApiTimeoutException {
		try {
			tentativas += 1;
			ResponseEntity<T> entityT = restTemplate.getForEntity(url, clazz);
			return entityT;
		} catch (RestClientException ex) {
			if (tentativas > 1)
				throw new ApiTimeoutException("API ViaCEP indisponível, tente novamente mais tarde!");
			return requisitarGet(url, clazz, tentativas);
		}
	}
}
