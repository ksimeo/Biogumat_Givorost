package com.ksimeo.nazaru.rest.services.impl;

import com.ksimeo.nazaru.core.models.User;
import com.ksimeo.nazaru.rest.dao.UserRepository;
import com.ksimeo.nazaru.rest.helpers.UserHelper;
import com.ksimeo.nazaru.rest.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author Ksimeo on 26.01.2015
 * @version 2.5
 * @since 1.0
 */
@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository usrDAO;

    @Override
    public User saveOne(User user) {
        try {
            user.setPassword(UserHelper.String2Hash(user.getPassword()));
            return usrDAO.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public User getOne(int id) {

        return usrDAO.findOne(id);
    }

    public User getOne(String login, String password) throws Exception {

        List<User> usrs = (List<User>) usrDAO.findAll();
        System.out.println(usrs);
        for (User usr : usrs) {
            if (usr.getLogin().equalsIgnoreCase(login)) {
                password = UserHelper.String2Hash(password);
                if (usr.getPassword().equals(password)) return usr;
                return null;
            }
        }
        return null;
    }

    @Override
    public User getOne(String login) {

        return usrDAO.findOneByLogin(login);
    }

    @Override
    public User getOneByEmail(String email) {

        List<User> usrs = (List<User>) usrDAO.findAll();
        for (User usr : usrs) {
            if (usr.getEmail().equalsIgnoreCase(email)) return usr;
        }
        return null;
//        return usrDAO.findOneByEmail(email);
    }

    @Override
    public void deleteOne(int id) {

        usrDAO.delete(id);
    }

    @Override
    public boolean isExist(String login) {

        List<User> users = (List<User>) usrDAO.findAll();
        for (User user : users) {
            if (user.getLogin().equalsIgnoreCase(login)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<User> getAll() {

        return (List<User>) usrDAO.findAll();
    }

    @Override
    public void deleteAll() {

        usrDAO.deleteAll();
    }

    @Override
    public User getOne(Map<String, String> usermap) {
        try {
            List<User> users = (List<User>) usrDAO.findAll();
            String login = usermap.get("login");
            String password = usermap.get("password");
            password = UserHelper.String2Hash(password);
            for (User user : users) {
                if (user.getLogin().equalsIgnoreCase(login)) {
                    if (user.getPassword().equals(password)) {
                        return user;
                    } else {
                        return null;
                    }
                }
            }
            return null;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private int getNumber() {
        List<User> users = (List<User>) usrDAO.findAll();
        int maxId = 0;
        for (User user : users) {
            if (user.getId() > maxId) maxId = user.getId();
        }
        return maxId;
    }
}