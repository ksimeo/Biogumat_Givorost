package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.rest.services.IProductService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * @author Ksimeo on 23.01.2015
 * @version 2.5
 * @since 1.0
 */
@Controller
public class ProductController {

    @Autowired
    private IProductService prodServ;

    private ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(
            value = "/addprod",
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public void addNewProduct(@RequestBody String data) throws IOException {

        data = new String (data.getBytes ("ISO-8859-1"), "utf-8");
        Product prod = mapper.readValue(data, Product.class);
        prodServ.saveOne(prod);
    }

    @RequestMapping(
            value = "/getprodbyid/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public Product getProductById(@PathVariable int id) {

        return prodServ.getById(id);
    }

    @RequestMapping(
            value = "/delprod/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    public void delProduct(@PathVariable int id) throws IOException {

        prodServ.delOne(id);
    }

    @RequestMapping(
            value = "/changeprod",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public void changeProduct(@RequestBody Product product) throws IOException {

        prodServ.editOne(product);
    }

    @RequestMapping(
            value = "/getprods",
            method = RequestMethod.GET,
            produces = "application/json")
    @ResponseBody
    public List<Product> getAllProducts() throws IOException {

        return prodServ.getAll();
    }

    @RequestMapping(
            value = "/delallprods",
            method = RequestMethod.DELETE,
            produces = "application/json")
    public void delAllProducts() throws IOException {

        prodServ.deleteAll();
//        return "all_products_deleted";
    }
}