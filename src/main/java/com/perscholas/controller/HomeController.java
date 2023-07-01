package com.perscholas.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Value("${spring.application.name}")
    String appName;

    @GetMapping(value = {"/", "index"})
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "index";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("appName", appName);
        return "login";
    }
    @GetMapping("/account")
    public  String accountPage(Model model){
        model.addAttribute("appName", appName);
        return "account";
    }
    @GetMapping("/register")
    public String registerPage(Model model){
        model.addAttribute("appName",appName);
        return "register";
    }

}
