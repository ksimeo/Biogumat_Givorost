package com.ksimeo.nazaru.rest.controllers;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import com.ksimeo.nazaru.rest.services.IOrderService;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

/**
 * Created by @author Ksimeo on 26.01.2015
 */
@Controller
public class OrderController {

    @Autowired
    private IOrderService orderServ;

    private ObjectMapper mapper = new ObjectMapper();


    @RequestMapping(
            value = "/addorder",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8",
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public Order addNewOrder(@RequestBody Order order) throws IOException {

        return orderServ.add(order);
    }

    @RequestMapping(
            value = "delorder/{id}",
            method = RequestMethod.GET)
    @ResponseBody
    private void delOrder(@PathVariable int id) throws IOException {

        orderServ.delete(id);
    }

    @RequestMapping(
            value = "/getorderspage/{p}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public Parcel getOrdersPage(@PathVariable int p) throws IOException {

        return orderServ.getParcel(p);
    }

    @RequestMapping(
            value = "/getordersint/from/{from}/to/{to}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getOrdersInt(@PathVariable int from, @PathVariable int to) throws Exception {

        return orderServ.getPage(from, to);
    }

    @RequestMapping(
            value = "from/{from}/to/{to}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getOrdersGroup(@PathVariable int from, @PathVariable int to) throws IOException {

        return orderServ.getPage(from, to);
    }

    @RequestMapping(
            value = "getorderscount",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public long getOrderCount() throws IOException {

        return orderServ.getCount();
    }

    @RequestMapping(
            value = "/getorders",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE + ";charset=UTF-8")
    @ResponseBody
    public List<Order> getAllOrders() {

        List<Order> orders = orderServ.getAll();
        return orders;
    }

    @RequestMapping(value = "/delorderbyid/{id}", method = RequestMethod.GET)
    @ResponseBody
    public void delOrderById(@PathVariable int id) {

        orderServ.delete(id);
    }


    //TODO Добавить метод который обрабатывал бы запросы по установке статуса заказов "Просмотренный".
}