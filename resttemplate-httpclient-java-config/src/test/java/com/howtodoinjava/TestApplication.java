package com.howtodoinjava;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import com.howtodoinjava.config.HttpClientConfig;
import com.howtodoinjava.config.RestTemplateConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { RestTemplateConfig.class, HttpClientConfig.class })
public class TestApplication {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void getEmployees() {
		final String uri = "http://localhost:8080/employees";

		String result = restTemplate.getForObject(uri, String.class);

		Assert.assertEquals(true, result.indexOf("Lokesh") > 0);
	}
}
