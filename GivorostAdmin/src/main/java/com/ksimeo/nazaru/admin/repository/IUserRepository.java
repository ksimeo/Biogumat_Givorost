package com.ksimeo.nazaru.admin.repository;

import com.ksimeo.nazaru.core.models.User;

import java.util.List;
import java.util.Properties;

/**
 * Created by @author Ksimeo on 16.04.2015
 */
public interface IUserRepository {

    User save(User usr) throws Exception;

    User check(Properties loginPassw) throws Exception;

    User findOne(int id) throws Exception;

    boolean findOne(String login) throws Exception;

    User findOneByEmail(String email) throws Exception;

    List<User> findAll() throws Exception;

    void delete(int id) throws Exception;
}