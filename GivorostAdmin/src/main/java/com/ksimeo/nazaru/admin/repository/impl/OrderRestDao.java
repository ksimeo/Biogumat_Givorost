package com.ksimeo.nazaru.admin.repository.impl;

import com.ksimeo.nazaru.admin.repository.IOrderRepository;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendGet;
import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendPost;

/**
 * Created by @author Ksimeo on 23.04.2016 at 17:25. For project: Givorost.
 */
@Repository
public class OrderRestDao implements IOrderRepository {

    private String urlBase = "http://localhost:6060/";
    private String fullUrl;
//    private String sendData;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Order save(Order order) throws Exception {

        fullUrl = urlBase + "addorder";
        String sendData = mapper.writeValueAsString(order);
        String echo = sendPost(fullUrl, sendData);
        Order result = mapper.readValue(echo, Order.class);
        return result;
    }

    @Override
    public Order findOne(int id) throws Exception {

        throw new UnsupportedOperationException();
    }

    @Override
    public Parcel findSomemany(int page) throws Exception {

        fullUrl = urlBase + "getorderspage/" + page;
        String echo = sendGet(fullUrl);
        Parcel result = mapper.readValue(echo, new TypeReference<Parcel>() { });
        /*Parcel<Order> result = mapper.readValue(echo, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));*/
        return result;
    }

    @Override
    public List<Order> findInterval(int from, int to) throws Exception {

        fullUrl = urlBase + "getordersint/from/" + from + "/to/" + to;
        String echo = sendGet(fullUrl);
        List<Order> result = mapper.readValue(echo, new TypeReference<List<Order>>() { });
        /*Parcel<Order> result = mapper.readValue(echo, mapper.getTypeFactory().constructCollectionType(List.class, Order.class));*/
        return result;
    }

    @Override
    public List<Order> findAll() throws Exception {

        fullUrl = urlBase + "getorders";
        String echo = sendGet(fullUrl);
        List<Order> result = mapper.readValue(echo, new TypeReference<List<Order>>() { });
        return result;
//        throw new UnsupportedOperationException();
    }

    @Override
    public void delete(int id) throws Exception {

        fullUrl = urlBase + "delorderbyid/" + id;
        sendGet(fullUrl);
    }

    @Override
    public void setViewedStatus(int id) throws Exception {

        fullUrl = urlBase + "setorderasview/" + id;
        sendGet(fullUrl);
    }
}
