package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.rest.services.impl.OrderService;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.JavaType;
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

import static junit.framework.TestCase.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by @Ksimeo on 26.01.2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/dispatcher-servlet.xml"})
@WebAppConfiguration
public class OrderControllerTest {

    @InjectMocks
    private OrderController oc;

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;

    @Autowired
    private OrderService os;

    List<Order> orderList;

    private Order order;

    @Before
    public void prepare() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        os.add(new Order("Иван","0938181491", "ksimeo@gmail.com", "Днепропетровская обл.", "Биогумат тип 1", 21));
        os.add(new Order("Николай", "0997517095", "maksym.fedorenko@gmail.com", "Черкасская обл.", "Биогумат тип 2", 12));
    }


    @Test
    public void testAddNewOrder() throws  Exception {
        Order order = new Order("Макс", "0567750544", "ximeo@mail.ru", "Винницкая обл.", "Биогумат тип 3", 4);
        ObjectMapper om = new ObjectMapper();
        String data = om.writeValueAsString(order);
        this.mockMvc.perform(post("/addorder").content(data).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    @Test
    public void testGetAllOrders() throws Exception {
        MvcResult res = this.mockMvc.perform(get("/getorders"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON+";charset=UTF-8")).andReturn();
        String data = res.getResponse().getContentAsString();
        ObjectMapper om = new ObjectMapper();
        JavaType type = om.getTypeFactory().constructCollectionType(List.class, Order.class);
        orderList = om.readValue(data, type);
        assertEquals(false, orderList.isEmpty());
    }
}