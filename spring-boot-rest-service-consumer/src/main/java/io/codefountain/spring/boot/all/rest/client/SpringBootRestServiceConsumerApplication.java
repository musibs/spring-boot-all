package io.codefountain.spring.boot.all.rest.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import io.codefountain.spring.boot.all.rest.client.domain.Quote;

@SpringBootApplication
public class SpringBootRestServiceConsumerApplication {

	private static final String API_URL = "https://gturnquist-quoters.cfapps.io/api/random";
	private static final Logger log = LoggerFactory.getLogger(SpringBootRestServiceConsumerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestServiceConsumerApplication.class, args);
	}

	
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {
		return restTemplateBuilder.build();
	}
	
	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) {
		return args -> {
			Quote quote = restTemplate.getForObject(API_URL, Quote.class);
			log.info("Quote is {}", quote.toString());
		};
	} 
}
