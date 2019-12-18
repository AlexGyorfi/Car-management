package com.alex.carmanagement.controller;

import com.alex.carmanagement.datamodel.User;
import com.alex.carmanagement.dto.UserDto;
import com.alex.carmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/api/users")
public class UserController {
    @Autowired
    private UserService userService;

//    @GetMapping(value = "/findByUsername/{username}")
//    public User findByUsername(@PathVariable(name = "username") String username) {
//        return userService.findByUsername(username);
//    }
//
//    @GetMapping(value = "/{id}")
//    public User findById(@PathVariable(name = "id") int id) {
//        return userService.findById(id);
//    }
//
//    @GetMapping(value = "/findAll")
//    public List<UserDto> findAll(@RequestParam(value = "page", defaultValue = "0") Integer page,
//                                 @RequestParam(value = "size", defaultValue = "5") Integer size,
//                                 @RequestHeader(value = "Test-Header", required = false) String testHeader) {
//        System.out.println(testHeader);
//        return userService.findAll(page, size);
//    }

    @PostMapping("/registration")
    public String createUser(@Valid User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registration";
        } else

            return "registration";
        }


//    @PutMapping(value = "/{id}")
//    public User updateUser(@PathVariable(name = "id") int id, @RequestBody User user) {
//        return userService.updateUser(id, user);
//    }

    @DeleteMapping(value = "/{id}")
    public String deleteUser(@PathVariable(name = "id") int id) {
        userService.deleteUser(id);
        return "The departement was deleted!";
    }


}
