package com.security.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.model.User;
import com.security.app.service.UserService;

@RestController
public class UserProfileController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/api/users/user/{id}",produces = "application/json")
    public User getUserDetail(@PathVariable Integer id){
        return userService.findById(id);
    }
}