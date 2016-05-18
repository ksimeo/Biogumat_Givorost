package com.ksimeo.nazaru.rest.services;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.List;

/**
 * Created by @author Ksimeo on 26.01.2015.
 */
public interface IOrderService {

    Order add(Order order);
    List<Order> getPage(int page);
    List<Order> getPage(int from, int to);
    List<Order> getAll();
    void deleteAll();
    void delete(int id);
    long getCount();
    Parcel getParcel(int page);
}