package com.ksimeo.nazaru.admin.repository.impl;

import com.ksimeo.nazaru.admin.repository.IUserRepository;
import com.ksimeo.nazaru.core.models.User;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Properties;

import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendGet;
import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendPost;

/**
 * @author Ksimeo on 16.04.2015
 * @version 2.5
 * @since 1.0
 */
@Repository
public class UserRestDao implements IUserRepository {

    private static String urlBase = "http://localhost:6060/";

    private ObjectMapper mapper = new ObjectMapper();


    @Override
    public User save(User usr) throws Exception {

        String fullUrl = urlBase + "addusr";
        String data = mapper.writeValueAsString(usr);
//        data = new String(data.getBytes("utf-8"), "ISO-8859-1");
        String echo = sendPost(fullUrl, data);
//        System.out.println(echo);
        echo = new String(echo.getBytes("ISO-8859-1"), "utf-8");
//        User user = mapper.readValue(echo, User.class);
        return mapper.readValue(echo, User.class);
    }

    @Override
    public User check(Properties loginPassw) throws Exception {

        String fullUrl = urlBase + "checkusr";
        String data = mapper.writeValueAsString(loginPassw);
        String echo = sendPost(fullUrl, data);
        User result = mapper.readValue(echo, User.class);
        return result;
    }

    @Override
    public User findOne(int id) throws Exception {

        String fullUrl = urlBase + "getusrbyid/" + id;
        String echo = sendGet(fullUrl);
        User result = mapper.readValue(echo, User.class);
        return result;
    }

    @Override
    public boolean findOne(String login) throws Exception {

        String fullUrl = urlBase + "getusrbylogin/" + login;
        String echo = sendGet(fullUrl);
//        System.out.println(echo);
//        return mapper.readValue(echo, User.class);
        return echo.equals("true");
    }

    @Override
    public User findOneByEmail(String email) throws Exception {

        String fullUrl = urlBase + "getusrbymail";
        String echo = sendPost(fullUrl, email);
        User usr = mapper.readValue(echo, User.class);
//        System.out.println(echo);
//        return mapper.readValue(echo, User.class);
        return usr;
    }

    @Override
    public List<User> findAll() throws Exception {

        String fullUrl = urlBase + "getusrs";
        String echo = sendGet(fullUrl);
        List<User> result = mapper.readValue(echo, new TypeReference<List<User>>() { });
        return result;
    }

    @Override
    public void delete(int id) throws Exception {

        String fullUrl = urlBase + "delusr/" + id;
        sendGet(fullUrl);
    }
}
