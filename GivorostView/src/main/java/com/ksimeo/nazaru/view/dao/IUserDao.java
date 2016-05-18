package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.User;

import java.util.List;
import java.util.Map;

/**
 * Created by @Ksimeo on 01.04.2015
 */
public interface IUserDao {

    List<User> getAllUsers();
    Map<String, User> getUsersMap();
    void deleteUser(int id);
    User getUser(int id);
}
