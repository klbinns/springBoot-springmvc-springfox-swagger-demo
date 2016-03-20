package com.binns.test.integration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

import com.binns.Application;
import com.binns.data.StringData;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(Application.class)
@WebIntegrationTest(randomPort = true)
public class StringManipulationIntegrationTest {

	@Value("${local.server.port}")
    private int port;

	private RestTemplate restTemplate = new TestRestTemplate();

	@Test
	public void testStringForward() {
		
		ResponseEntity<StringData> entity = 
				this.restTemplate.getForEntity("http://localhost:" + this.port + "/string/forward/forwardtest", StringData.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getOutput()).isEqualTo("forwardtest");
	}
	
	@Test
	public void testStringReverse() {
		
		ResponseEntity<StringData> entity = 
				this.restTemplate.getForEntity("http://localhost:" + this.port + "/string/reverse/reversetest", StringData.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getOutput()).isEqualTo("tsetesrever");
	}
	
	@Test
	public void testStringDropVowel() {
		
		ResponseEntity<StringData> entity = 
				this.restTemplate.postForEntity("http://localhost:" + this.port + "/string/dropVowels/dropvoweltest", null, StringData.class);
		assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(entity.getBody().getOutput()).isEqualTo("drpvwltst");
	}
	
	
	
}
