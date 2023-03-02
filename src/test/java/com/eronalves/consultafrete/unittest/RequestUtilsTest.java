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

	@Autowired
	RequestUtil requestUtil;

	@Test
	public void deveJogarErroEmTimeout() throws RestClientException, InterruptedException {
		assertThrows(ApiTimeoutException.class,
				() -> requestUtil.requisitarGet("http://10.255.255.1/", EnderecoResponse.class));
	}
}
