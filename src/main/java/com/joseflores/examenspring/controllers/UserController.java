package com.joseflores.examenspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import com.joseflores.examenspring.models.User;
import com.joseflores.examenspring.services.UserServices;
import com.joseflores.examenspring.validations.UserValidator;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("")
public class UserController {
    private final UserServices userService;
    private final UserValidator userValidator;

  public UserController(UserServices userService, UserValidator userValidator) {
    this.userService = userService;
    this.userValidator = userValidator;
    }
    @PostMapping("/register")
    public String registro(@Valid @ModelAttribute("user") User user, BindingResult
    result, HttpSession session) {
        if (result.hasErrors()) {
            return "form.jsp";
            }
          userService.save(user);
          session.setAttribute("userid", user.getId());
            return "redirect:/programas";
    }
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user")User user, BindingResult result, HttpSession session) {
        if (result.hasErrors()) {
            return "form.jsp";
        }
        session.setAttribute("userid", user.getId());
        return "redirect:/programas";
    }
    
}