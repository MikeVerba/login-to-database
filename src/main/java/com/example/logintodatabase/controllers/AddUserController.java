package com.example.logintodatabase.controllers;

import com.example.logintodatabase.models.UserForm;
import com.example.logintodatabase.models.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AddUserController {

    @Autowired
    UserService userService;

    @GetMapping("/add-user")
    public String loginForm(Model model){
        model.addAttribute("user",new UserForm());
        return "add-user";
    }
    @PostMapping("add-user")
    @ResponseBody
    public String getUser(@ModelAttribute UserForm userForm){

        if(!userService.addUser(userForm)){
            return "username is busy";
        }


        return "Thank you!!";

    }
}
