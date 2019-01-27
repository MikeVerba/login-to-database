package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.Contact;
import com.example.logintodatabase.models.services.ContactService;
import com.example.logintodatabase.models.services.UserSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AddContactController {

    @Autowired
    ContactService contactService;

    @Autowired
    UserSession userSession;


    @GetMapping("/add-contact")
    public String addContact(Model model){
        model.addAttribute("contact",new Contact());
        return "add-contact";
    }

    @PostMapping
    public String saveContact(@ModelAttribute Contact contact){

        contactService.addContact(contact,userSession.getUserEntity().getId());
        return "contact-added";
    }
}
