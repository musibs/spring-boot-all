package io.codefountain.spring.boot.all.docker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DockerController {

	@GetMapping
	public String index() {
		return "index";
	}
}
