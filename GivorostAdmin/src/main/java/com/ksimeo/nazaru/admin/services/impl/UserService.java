package com.ksimeo.nazaru.admin.services.impl;

import com.ksimeo.nazaru.admin.services.IUserService;
import com.ksimeo.nazaru.core.models.User;
import com.ksimeo.nazaru.admin.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Properties;

/**
 * @author Ksimeo on 01.04.2015
 * @version 2.5
 * @since 1.0
 */
@Service
public class UserService implements IUserService {

    @Autowired
    IUserRepository usrDAO;

    @Override
    public User addUser(User usr) throws Exception {

        return usrDAO.save(usr);
    }

    @Override
    public void editUser(User user) throws Exception {

        delUser(user.getId());
        addUser(user);
    }

    @Override
    public User getUser(int id) throws Exception {

            return usrDAO.findOne(id);
    }

    @Override
    public User getUser(String login, String password) throws Exception {

        Properties loginPassw = new Properties();
        loginPassw.setProperty("login", login);
        loginPassw.setProperty("password", password);
        return usrDAO.check(loginPassw);
    }

    @Override
    public User getUserByMail(String mail) throws Exception {

        return usrDAO.findOneByEmail(mail);
    }


    @Override
    public List<User> getUsers() throws Exception {

            return usrDAO.findAll();
    }

    @Override
    public void delUser(int id) throws Exception {

        usrDAO.delete(id);
    }

    @Override
    public boolean isLoginExist(String login) throws Exception {

        return usrDAO.findOne(login);
    }
}