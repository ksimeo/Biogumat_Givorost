package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.rest.services.IProductService;
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

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by @author Ksimeo on 27.01.2015
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/config/dispatcher-servlet.xml"})
@WebAppConfiguration
public class ProductControllerTest {

    @InjectMocks
    private ProductController pc;

    @Autowired
    WebApplicationContext wac;

    private MockMvc mockMvc;

    @Autowired
    private IProductService prodServ;

    ObjectMapper mapper = new ObjectMapper();

    private Product testProd1;
    private Product testProd2;

    @Before
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
        testProd1 = prodServ.saveOne(new Product("Биогумат марки 1", 3.99F, 0.99F));
        testProd2 = prodServ.saveOne(new Product("Биогумат марки 2", 2.54F, 0.51F));
    }

    @Test
    public void testAddNewProduct() throws Exception {

        Product prod = new Product("Биогумат марки 3", 5.21F, 2.51F);
        String data = mapper.writeValueAsString(prod);
        mockMvc.perform(post("/addprod").content(data).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetProductById() throws Exception {

        MvcResult res = mockMvc.perform(get("/getprodbyid/" + testProd2.getId()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON + ";charset=UTF-8"))
                .andReturn();
        String data = res.getResponse().getContentAsString();
        ObjectMapper mapper = new ObjectMapper();
        Product recProd = mapper.readValue(data, Product.class);
        assertNotNull(recProd);
        assertEquals(recProd.getId(), testProd2.getId());
    }

    @Test
    public void testDeleteProduct() throws Exception {
        this.mockMvc.perform(get("/delprod/" + testProd1.getId()))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllProducts() throws Exception {
        MvcResult res = this.mockMvc.perform(get("/getprods"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON)).andReturn();
        String data = res.getResponse().getContentAsString();
        ObjectMapper om = new ObjectMapper();
        JavaType type = om.getTypeFactory().constructCollectionType(List.class, Product.class);
        List<Order> orderList = om.readValue(data, type);
        assertEquals(false, orderList.isEmpty());
    }

    @After
    public void purge() {

//        prodServ.deleteAllProducts();
    }
}
