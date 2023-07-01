package com.perscholas.controller;

import com.perscholas.dto.UserDto;
import com.perscholas.persistence.model.User;
import com.perscholas.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;



@Controller
public class AuthController {
    private UserService userService;

    @Value("${spring.application.name}")
    String appName;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

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
    public String accountPage(Model model) {
        model.addAttribute("appName", appName);
        return "account";
    }

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("user", new UserDto());
        return "register";
    }

    @PostMapping("/register/save")
    public String registration(@Valid @ModelAttribute("user") UserDto userDto, BindingResult result,
                               Model model) {
        User existingUser = userService.findUserByEmail(userDto.getEmail());

        if (existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()) {
            result.rejectValue("email", null, "There is already an account registered with the same email");
        }

        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "/register";
        }
        userService.createUser(userDto);
        return "redirect:/register?success";
    }
}