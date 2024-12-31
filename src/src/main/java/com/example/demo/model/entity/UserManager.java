package com.example.demo.model.entity;

import com.example.demo.service.UserService;

public class UserManager {
    private static UserManager instance;

    private UserManager() { }

    public static UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }




}