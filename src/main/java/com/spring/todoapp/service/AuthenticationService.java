package com.spring.todoapp.service;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean isAuthenticate(String name, String password){
        boolean isValidUserName = name.equals("Deepak");
        boolean isValidPassword = password.equals("00000");

        return isValidUserName && isValidPassword;
    }
}
