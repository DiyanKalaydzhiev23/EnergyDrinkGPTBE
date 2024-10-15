package com.energydrinkgpt.dao;

import com.energydrinkgpt.entity.User;
import java.util.List;

public interface UserDAO {
    void saveUser(User user);

    User getUserById(int id);

    List<User> getAllUsers();

    void deleteUser(int id);

    void verifyUser(int id);
}
