package com.energydrinkgpt.dao;

import com.energydrinkgpt.config.TransactionUtil;
import com.energydrinkgpt.entity.User;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    @Override
    public void saveUser(User user) {
        TransactionUtil.executeWithTransaction(session -> {
            session.merge(user);
            return null; // No return value
        });
    }

    @Override
    public User getUserById(int id) {
        return TransactionUtil.executeWithTransaction(session -> session.get(User.class, id));
    }

    @Override
    public List<User> getAllUsers() {
        return TransactionUtil.executeWithTransaction(session ->
                session.createQuery("from User", User.class).list()
        );
    }

    @Override
    public void verifyUser(int id) {
        TransactionUtil.executeWithTransaction(session -> {
            User user = session.get(User.class, id);

            if (user != null) {
                user.setVerified(true);
                session.merge(user);
            }

            return null;
        });
    }

    @Override
    public void deleteUser(int id) {
        TransactionUtil.executeWithTransaction(session -> {
            User user = session.get(User.class, id);
            if (user != null) {
                session.remove(user);
            }

            return null;
        });
    }
}
