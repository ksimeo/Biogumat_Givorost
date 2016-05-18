package com.ksimeo.nazaru.view.requests.impl;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.view.requests.OrderRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ksimeo.nazaru.view.helpers.RequestHelper.sendGet;
import static com.ksimeo.nazaru.view.helpers.RequestHelper.sendPost;

/**
 * @author Created by Ksimeo on 16.04.2015
 * @version 2.5
 * @since 1.0
 */
@Repository
public class OrderRestDao implements OrderRepository {

    private String urlBase = "http://localhost:6060";

    @Override
    public void sendOrder(Order order) {
        try {
            ObjectMapper om = new ObjectMapper();
            String data = om.writeValueAsString(order);
            data = new String(data.getBytes("utf-8"), "ISO-8859-1");
            String fullUrl = urlBase + "/addorder";
            System.out.println(order);
            sendPost(fullUrl, data);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
