package com.ksimeo.nazaru.admin.services;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.List;

/**
 * Created by @author Ksimeo on 18.03.2015
 */
public interface IOrderService {

    void addOrder(Order order) throws Exception;
    Order getOrder(int id) throws Exception;
    Parcel<Order> getPage(int page) throws Exception;
    List<Order> getOrders() throws Exception;
    void delOrder(int id) throws Exception;
    void setAsViewed(int id) throws Exception;
    void update();
}
