package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.Contact;
import com.example.logintodatabase.models.services.ContactService;
import com.example.logintodatabase.models.services.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DatabaseController {

    @Autowired
    ContactService contactService;

    @Autowired
    UserSession userSession;

    @GetMapping("/database")
    public String database(Model model){

        if(!userSession.isLogin()){
            return "database-failed";
        }
        model.addAttribute("contactList",contactService.getContacts());
        return "database";
    }



}
