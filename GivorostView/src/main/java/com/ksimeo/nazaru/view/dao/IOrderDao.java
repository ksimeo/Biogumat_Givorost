package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.List;

/**
 * Created by @Ksimeo on 18.03.2015.
 */
public interface IOrderDao {

    void saveOrder(Order order);
    List<Order> getOrders();
//    List<Order> getPage();
    List<Order> getPage(int from, int to);
    Parcel<Order> getOrdersPage(int page);
    Parcel<Order> getOrdersPage();
    int getLastId();
}
