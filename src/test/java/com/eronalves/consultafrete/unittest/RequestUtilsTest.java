package com.eronalves.consultafrete.unittest;

import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestClientException;

import com.eronalves.consultafrete.exception.ApiTimeoutException;
import com.eronalves.consultafrete.models.response.EnderecoResponse;
import com.eronalves.consultafrete.utils.RequestUtil;

@SpringBootTest
public class RequestUtilsTest {

	private static final String IP_NAO_ROTEAVEL = "http://10.255.255.1/";
	@Autowired
	RequestUtil requestUtil;

	@Test
	public void deveJogarErroEmTimeout() throws RestClientException, InterruptedException {
		assertThrows(ApiTimeoutException.class,
				() -> requestUtil.requisitarGet(IP_NAO_ROTEAVEL, EnderecoResponse.class));
	}
}
