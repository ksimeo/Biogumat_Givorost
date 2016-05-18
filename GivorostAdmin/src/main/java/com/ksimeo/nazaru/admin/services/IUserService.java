package com.ksimeo.nazaru.admin.services;

import com.ksimeo.nazaru.core.models.User;

import java.util.List;

/**
 * Created by @author Ksimeo on 08.04.2015
 */
public interface IUserService {

    User addUser(User usr) throws Exception;
    User getUser(int id) throws Exception;
    User getUser(String login, String password) throws Exception;
    List<User> getUsers() throws Exception;
    void editUser(User user) throws Exception;
    void delUser(int id) throws Exception;
    boolean isLoginExist(String login) throws Exception;
    User getUserByMail(String mail) throws Exception;
}

