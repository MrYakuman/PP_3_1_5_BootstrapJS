package ru.kata.spring.boot_security.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;


import java.security.Principal;


@Controller
public class UserController {
    private final UserService service;
    private final RoleService roleService;

    @Autowired
    public UserController(UserService service, RoleService roleService) {
        this.service = service;
        this.roleService = roleService;
    }

    @GetMapping("/registration")
    public String registrationPage(@ModelAttribute("user") User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String performRegistration(@ModelAttribute("user") User user) {
        service.registration(user);
        return "redirect:/login";
    }

    @GetMapping("/user")
    public String userPage(Model model, Principal principal) {
        User userByName = service.getUserByUsername(principal.getName());
        model.addAttribute("user", userByName);
        model.addAttribute("pageTitle", userByName.getUsername());
        return "userPage";
    }
}
