package com.eronalves.consultafrete.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.eronalves.consultafrete.exception.ApiTimeoutException;

/**
 * Classe que irá executar e fazer tentativas na requisição a um serviço externo
 * de CEP
 * 
 * @author eronads
 *
 */
@Component
public class RequestUtil {

	@Autowired
	private RestTemplate restTemplate;

	/**
	 * Realiza a consulta e uma tentativa a mais a um determinado endpoint
	 * 
	 * @param <T>   Classe que irá retornar dentro do ResponseEntity
	 * @param url   URL da requisição
	 * @param clazz Classe que irá retornar
	 * @return Um ResponseEntity
	 * @throws ApiTimeoutException Quando o endpoint está indisponível, após duas
	 *                             tentativas
	 */
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
