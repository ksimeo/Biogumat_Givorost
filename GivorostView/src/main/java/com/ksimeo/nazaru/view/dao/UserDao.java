package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by @Ksimeo on 01.04.2015
 */
public class UserDao implements IUserDao {

    private List<User> users;

    public UserDao() {
        users = new ArrayList<>();
//        users.add(new User(1, "Назар Васильевич", "Nazar", "Samarchuk", true));
//        users.add(new User(2, "Максим", "Maks", "Ksimeo", true));
//        users.add(new User(3, "Вася Пупкин", "Vasya", "#12345", false));
    }

    @Override
    public List<User> getAllUsers() {

        return users;
    }

    @Override
    public Map<String, User> getUsersMap() {
        Map<String, User> userMap = new HashMap<>();
        userMap.put("Nazar", new User("Назар Васильевич", "Nazar", "nazarz@meta.ua", "Samarchuk", true));
        userMap.put("Maks", new User("Максим", "Maks", "ksimeo@gmail.com", "Ksimeo", true));
        userMap.put("Vasya", new User("Вася Пупкин", "Vasya", "vasya@hotmail.com", "#12345", false));
        return userMap;
    }

    @Override
    public void deleteUser(int id) {

        users.remove(id-1);
    }

    @Override
    public User getUser(int id) {

        return users.get(id-1);
    }
}
