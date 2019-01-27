package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.services.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class IndexController {
    @Autowired
    UserSession userSession;



    @GetMapping("/")
    public String index(){
        if(!userSession.isLogin()){
            return "you-are-not-logged-in";
        }
        return "index";
    }
}
