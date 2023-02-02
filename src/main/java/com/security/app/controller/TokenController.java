package com.security.app.controller;

import java.io.File;
import java.io.IOException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.security.app.service.UserService;

@RestController
public class TokenController {

    @Autowired
    private UserService customerService;

    @PostMapping("/token")
    public String getToken(@RequestParam("username") final String username, @RequestParam("password") final String password){
       String token= customerService.login(username,password);
       System.out.println("Token :"+token);
       if(StringUtils.isEmpty(token)){
           return "no token found";
       }
       return token;
    }
    
    @GetMapping("/currentdirectory")
    public String getDirectory() throws IOException
    {
    	String name = new File(".").getCanonicalPath();
    	return name;
    }
}