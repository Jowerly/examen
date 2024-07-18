package com.joseflores.examenspring.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.services.ProgramServices;
import com.joseflores.examenspring.services.RolesServices;
import com.joseflores.examenspring.services.UserServices;
import com.joseflores.examenspring.validations.UserValidator;

@Controller
public class HomeController {
    @Autowired
    private UserServices userServices;
    @Autowired 
    private ProgramServices programServices;
    @Autowired
    private RolesServices rolesServices;

    private final UserValidator userValidator;

    public HomeController(UserServices userServices, UserValidator userValidator){
        this.userValidator = userValidator;
    }
    @GetMapping("")
    public String formRegisterAndLogin(@ModelAttribute("user") User userEntity) {
        return "form.jsp";
    }
    }
