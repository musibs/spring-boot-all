package io.codefountain.spring.boot.all.restservice.controller;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.codefountain.spring.boot.all.restservice.domain.Greeting;

@RestController
public class GreetingsController {
	
	private final String GREETING_TEMPLATE = "Hello, %s";
	private final AtomicInteger counter = new AtomicInteger();
	
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(GREETING_TEMPLATE, name));
	} 
	

}
