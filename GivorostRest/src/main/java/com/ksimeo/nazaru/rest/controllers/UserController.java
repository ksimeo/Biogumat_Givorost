package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.User;
import com.ksimeo.nazaru.rest.services.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Properties;

/**
 * @author Ksimeo on 23.01.2015
 * @version 2.5
 * @since 1.0
 */
@Controller
public class UserController {

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private IUserService uServ;


    @RequestMapping(
            value = "/addusr",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User addUser(@RequestBody String data) throws Exception {

        data = new String(data.getBytes("ISO-8859-1"), "utf-8");
//        System.out.println("Входящий поток:" + data);
        User user = mapper.readValue(data, User.class);
        return uServ.saveOne(user);
    }

    @RequestMapping(
            value = "/delusr/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public void delUserById(@PathVariable int id) {

        uServ.deleteOne(id);
    }

    @RequestMapping(
            value = "/getusrbyid/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUserById(@PathVariable int id) {

        return uServ.getOne(id);
    }


    @RequestMapping(
            value = "/getusrbylogin/{login}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUserByLogin(@PathVariable String login) {
        
        return uServ.getOne(login);
    }

    @RequestMapping(
            value = "/getusrbymail",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUserByMail(@RequestBody String mail) {

        return uServ.getOneByEmail(mail);
    }


    @RequestMapping(
            value = "/checkusrbylogin/{login}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public boolean checkUserByLogin(@PathVariable String login) {

        return uServ.getOne(login) != null;
    }

 /*   @RequestMapping(
            value = "/getusrbymail/{mail}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUserByMail(@PathVariable String mail) {
        return uServ.getOneByEmail(mail);
    }*/

    @RequestMapping(
            value = "/getusrs",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<User> getAllUsers() throws Exception {
        List<User> result = uServ.getAll();
        System.out.println(result);
        return result;
    }

    @RequestMapping(
            value = "/getusrbyemail/{email}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User getUserByEmail(@PathVariable String email) {
        return uServ.getOneByEmail(email);
    }

    @RequestMapping(value = "/checkusr", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public User checkUser(@RequestBody String data) throws Exception {
        Properties usr = mapper.readValue(data, Properties.class);
        String login = usr.getProperty("login");
        String passw = usr.getProperty("password");
        return uServ.getOne(login, passw);
    }
}