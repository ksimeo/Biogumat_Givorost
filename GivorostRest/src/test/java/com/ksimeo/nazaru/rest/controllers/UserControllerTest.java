package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.User;
import com.ksimeo.nazaru.rest.services.IUserService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Properties;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


/**
 * @author Ksimeo on 26.01.2015
 * @version 2.5
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/dispatcher-servlet.xml"})
@WebAppConfiguration
public class UserControllerTest {

    @InjectMocks
    private UserController uc;

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private IUserService serv;

    private User usr;

    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        serv.saveOne(new User("Назару Васильевичу", "Nazar", "Samarchuk", "nazarz@meta.ua", true));
        serv.saveOne(new User("Тестовый пользователь", "Test", "test123", "testuser@hotmail.com", false));
    }

    @Test
    public void testAddUser() throws Exception {

        usr = new User("Макс", "Ksimeo", "max123", "ksimeo@gmail.com", true);
        String data = mapper.writeValueAsString(usr);
        MvcResult mvcResult = mockMvc.perform(post("/addusr").content(data).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk()).andReturn();
        data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        assertNotNull(usr);
    }

    @Test
    public void testDeleteUser() throws Exception {

        String login = "Test";
        MvcResult mvcResult = mockMvc.perform(get("/getusrbylogin/" + login))
                .andExpect(status().isOk())
                .andReturn();
        String data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        int id = usr.getId();
//        int id = 2;
        mockMvc.perform(get("/delusr/" + id))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetUserByID() throws Exception {

        String login = "Ksimeo";
        MvcResult mvcResult = mockMvc.perform(get("/getusrbylogin/" + login))
                .andExpect(status().isOk())
                .andReturn();
        String data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        int id = usr.getId();
        mvcResult = mockMvc.perform(get("/getusrbyid/" + id))
                .andExpect(status().isOk()).andReturn();
        data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        assertNotNull(usr);
    }

    @Test
    public void testGetUserByLogin() throws Exception {

        String login = "nazar";
        MvcResult mvcResult = mockMvc.perform(get("/getusrbylogin/" + login))
                .andExpect(status().isOk())
                .andReturn();
        String data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        assertNotNull(usr);
    }

    @Test
    public void testGetUserByMail() throws Exception {

        String mail = "nazarz@meta.ua";
        MvcResult mvcResult = mockMvc.perform(post("/getusrbymail").content(mail).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();
        String data = mvcResult.getResponse().getContentAsString();
        System.out.println("Get by email:" + data);
        usr = mapper.readValue(data, User.class);
        assertNotNull(usr);
    }

    @Test
    public void testCheckUser() throws Exception {

        Properties prop = new Properties();
        prop.put("login", "ksimeo");
        prop.put("password", "max123");
        String data = mapper.writeValueAsString(prop);
        MvcResult mvcResult = mockMvc.perform(post("/checkusr").content(data).contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("utf-8"))
                .andExpect(status().isOk())
                .andReturn();
        data = mvcResult.getResponse().getContentAsString();
        usr = mapper.readValue(data, User.class);
        assertNotNull(data);
//        assertEquals(data, "true");
    }

    @Test
    public void testGetAllUsers() throws Exception {

        MvcResult res = mockMvc.perform(get("/getusrs"))
                .andExpect(status().isOk())
                .andReturn();
        String data = res.getResponse().getContentAsString();
        JavaType type = mapper.getTypeFactory().constructCollectionType(List.class, User.class);
        List<User> usrs = mapper.readValue(data, type);
        assertNotNull(usrs);
        assertFalse(usrs.isEmpty());
    }

    @After
    public void purge() {

    }
}
