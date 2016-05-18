package com.ksimeo.nazaru.view.requests;

import com.ksimeo.nazaru.core.models.Order;

/**
 * Created by @Ksimeo on 16.04.2015
 */
public interface OrderRepository {

    void sendOrder(Order order);

//    List getProducts();
//
//    Product getProductById(int id);
}
