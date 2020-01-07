package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping(value = "/list")
//    public String findAllUsers(Model model) {
//        List<User> users = userService.findAllUsers();
//        model.addAttribute("users", users);
//        return "listUsers";
//    }

    @GetMapping(value = "/loggedInUser")
    public String loggedInUser(String username, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String userName = authentication.getName();
        User loggedInUser = userService.getUserByUsername(userName);
        List <User> users =new ArrayList<>();
        users.add(loggedInUser);
        model.addAttribute("users", users);
        return "loggedInUser";
    }

    @GetMapping(value = "/registration")
    public String showUserRegistration(Model model) {
        model.addAttribute("user", new User());
        return "registration";
    }



    @PostMapping(value = "/registration")
    public String createUser(@Valid User user, BindingResult result) {
        if (result.hasErrors()) {
            return "registration";
        } else
            userService.createUser(user);
        return "redirect:/users/loggedInUser";
    }

    @PostMapping(value = "/delete")
    public String deleteUser(@ModelAttribute(name = "userId") Integer userId, Model model) {
        userService.deleteUser(userId);
        return "redirect:/users/registration";
    }
    @GetMapping(value = "/update")
    public String updateUserSendForm(@RequestParam("userId") Integer userId, Model model) {
        model.addAttribute("user", userService.findById(userId));
        return "updateUser";
    }

    @PostMapping(value = "/update")
    public String updateCarProcessForm(@ModelAttribute(name = "user") User user, Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        User loggedInUser = userService.getUserByUsername(username);
        user.setPassword(loggedInUser.getPassword());
        model.addAttribute("user", loggedInUser);
        userService.updateUser(user);
        return "redirect:/users/loggedInUser";
    }
}
