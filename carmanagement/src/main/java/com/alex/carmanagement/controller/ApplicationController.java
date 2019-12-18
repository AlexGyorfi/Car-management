package com.alex.carmanagement.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller("/")
public class ApplicationController {

    @GetMapping("")
    public String loginView() {
        return "login";
    }
    @Secured("ROLE_ADMIN")
    @GetMapping(value = "/rest")
    public String currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UserDetails principal = (UserDetails) authentication.getPrincipal();

        String roles = "";
        for (GrantedAuthority simpleGrantedAuthority : authentication.getAuthorities()) {
            roles = roles + simpleGrantedAuthority.getAuthority() + " ";
        }
        return "Current username is: " + principal.getUsername()
                + " and the roles are: " + roles;
    }
}
