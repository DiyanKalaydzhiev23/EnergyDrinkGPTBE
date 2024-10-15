package com.energydrinkgpt;

import com.energydrinkgpt.config.HibernateUtil;
import com.energydrinkgpt.entity.User;
import com.energydrinkgpt.service.UserService;
import com.energydrinkgpt.service.UserServiceImpl;

public class MainApp {

    public static void main(String[] args) {
        createUser();

        HibernateUtil.shutdown();
    }

    public static void createUser() {
        UserService userService = new UserServiceImpl();

        User newUser = new User();
        newUser.setUsername("jane_doe");
        newUser.setEmail("jane.doe@example.com");
        newUser.setPassword("password123");
        newUser.setVerified(false);

        try {
            userService.createUser(newUser);
            System.out.println("User created successfully.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error creating user: " + e.getMessage());
        }
    }
}
