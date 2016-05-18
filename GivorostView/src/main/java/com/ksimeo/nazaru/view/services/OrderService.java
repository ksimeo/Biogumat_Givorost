package com.ksimeo.nazaru.view.services;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.view.requests.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by @Ksimeo on 18.03.2015
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private OrderRepository rs;

    private OrderService() { }

    @Override
    public void saveNewOrder(Order order) {

       rs.sendOrder(order);
    }
}
