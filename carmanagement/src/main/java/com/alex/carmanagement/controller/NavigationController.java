package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class NavigationController {

    @GetMapping(value = "/home")
    public String home(){

        return "home";
    }
    @GetMapping(value = "/login")
    public String showUserLogin(Model model) {
        model.addAttribute("user", new User());
        return "login";
    }
}
