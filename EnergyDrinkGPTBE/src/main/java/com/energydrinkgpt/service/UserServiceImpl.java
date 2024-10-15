package com.energydrinkgpt.service;

import com.energydrinkgpt.dao.UserDAO;
import com.energydrinkgpt.dao.UserDAOImpl;
import com.energydrinkgpt.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserServiceImpl implements UserService {

    private UserDAO userDAO = new UserDAOImpl();

    // instance of BCryptPasswordEncoder to hash passwords
    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public void createUser(User user) {
        String hashedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(hashedPassword);

        userDAO.saveUser(user);
    }
}
