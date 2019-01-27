package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.services.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LogoutController {

    @Autowired
    UserSession userSession;

    @GetMapping("/logout")
    public String logout(){

        userSession.setLogin(false);
        return "logout";
    }
}
