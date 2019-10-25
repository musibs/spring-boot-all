package io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class WelcomeController {

    @GetMapping("/welcome")
    public String hello(Model model){
        System.out.println("Hello");
        model.addAttribute("date", new Date());
        return "welcome";
    }
}
