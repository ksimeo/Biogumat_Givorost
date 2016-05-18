package com.ksimeo.nazaru.admin.repository.mocks;

import com.ksimeo.nazaru.admin.repository.IUserRepository;
import com.ksimeo.nazaru.core.models.User;

import java.util.List;
import java.util.Properties;

/**
 * Created by @author Ksimeo on 30.04.2016 at 10:49. For project: Givorost.
 */
//@Repository
public class UserRepositoryMock implements IUserRepository {

    User user1 = new User("Назар Васильевич", "Nazar", "Samarchuk", "nazarz@ukr.net", true);
    User user2 = new User("Макс", "Maks", "#1234", "ksimeo@gmail.com", true);
    User user3 = new User("Василий", "Vasya", "123", "vasya@hotmail.com", false);

    public UserRepositoryMock() {
//        user1 = new User("Назар Васильевич", "Nazar", "Samarchuk", "nazarz@ukr.net", true);
//        user2 = new User("Макс", "Maks", "#1234", "ksimeo@gmail.com", true);
//        user3 = new User("Василий", "Vasya", "123", "vasya@hotmail.com", false);
    }

    @Override
    public User save(User usr) throws Exception {

        return null;
    }

    @Override
    public User check(Properties client) throws Exception {
        if (client.getProperty("login").equalsIgnoreCase("Nazar") && client.getProperty("password").equals("Samarchuk")) return user1;
        if (client.getProperty("login").equalsIgnoreCase("Maks") && client.getProperty("password").equals("#1234")) return user2;
        if (client.getProperty("login").equalsIgnoreCase("Vasya") && client.getProperty("password").equals("123")) return user3;
        return null;
    }

    @Override
    public User findOne(int id) throws Exception {
        return null;
    }

    @Override
    public boolean findOne(String login) throws Exception {

        return false;
    }

    @Override
    public List<User> findAll() throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public User findOneByEmail(String email) throws Exception {
        return null;
    }

}
