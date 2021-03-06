package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.repositories.UserRepository;
import com.example.logintodatabase.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {

    @Autowired
    UserService userService;


    @GetMapping("/login-form")
    public String loginForm(Model model) {
        model.addAttribute("user", new UserForm());
        return "login-form";
    }

    @PostMapping("login-form")
    public String getUser(@ModelAttribute UserForm userForm) {

        if (userService.login(userForm)) {
            return "login-succes";
        }

        return "login-failed";
    }
}
