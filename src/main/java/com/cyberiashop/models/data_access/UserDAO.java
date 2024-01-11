package com.cyberiashop.models.data_access;

import com.cyberiashop.models.data_models.User;

import java.util.List;


public interface UserDAO {
    void save(User user);

    User getByUsername(String username);

    User getByUsernameAndPassword(String username, String password);

    void deleteByUsername(String username);

    List<User> getAll();
}
