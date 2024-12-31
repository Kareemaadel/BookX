package com.example.demo.controller;

import com.example.demo.model.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model) {
        User User=new User();
        model.addAttribute("User",User);        // Show registration page
        return "register";
    }

    @GetMapping("/login")
    public String login(Model model) {
        // Show login page
        return "login";
    }
    @GetMapping("/welcome")
    public String welcome(Model model) {
        // Add a dummy user to test the view
        User user = new User();
        user.setName("Test User");
        model.addAttribute("user", user);
        return "welcome";
    }

    @PostMapping
    public String performRegister(@ModelAttribute("User")User user , Model model) {
        userService.register(user);
        return "redirect:/welcome";    }
}