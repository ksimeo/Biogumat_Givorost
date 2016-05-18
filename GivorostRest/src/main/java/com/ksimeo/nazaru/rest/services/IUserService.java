package com.ksimeo.nazaru.rest.services;

import com.ksimeo.nazaru.core.models.User;

import java.util.List;
import java.util.Map;

/**
 * Created by @author Ksimeo on 26.01.2015
 */
public interface IUserService {

    User saveOne(User user);

    User getOne(int id);

    User getOne(Map<String, String> usermap);

    User getOne(String login, String password) throws Exception;

    User getOne(String login);

    User getOneByEmail(String email);

    void deleteOne(int id);

    //    User getByName(String name);
    List<User> getAll();

    void deleteAll();

    boolean isExist(String login);
}