package br.com.cartorio.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor(access = AccessLevel.PACKAGE)
public class Config {

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
