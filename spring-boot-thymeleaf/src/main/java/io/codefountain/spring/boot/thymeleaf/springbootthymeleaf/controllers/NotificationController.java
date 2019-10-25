package io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.controllers;

import io.codefountain.spring.boot.thymeleaf.springbootthymeleaf.model.Notification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotificationController {

    @GetMapping("/notification")
    public String getNotification(Model model){
        Notification notification = new Notification();
        model.addAttribute("notification", notification);
        return "notification";
    }

    @PostMapping("/notification")
    public String postNotification(@ModelAttribute(value = "notification") Notification notification, BindingResult bindingResult, Model model){
        System.out.println("Model Hit");
        System.out.println("Notifications: "+notification);
        model.addAttribute("notification", notification);
        System.out.println("Binding Result: "+bindingResult);
        return "notificationSuccess";
    }
}
