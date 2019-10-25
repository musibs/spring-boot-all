package io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.controllers;

import io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
public class PersonController {

    @GetMapping("/persons")
    public ModelAndView getAllPersons(){

        ModelAndView modelAndView = new ModelAndView("persons");
        modelAndView.addObject("persons", Arrays.asList(new Person[]{
            new Person("John", "Doe", 24.1, "M"), new Person("Ranjana", "K", 22.3, "F")
        }));
        return modelAndView;
    }
}
