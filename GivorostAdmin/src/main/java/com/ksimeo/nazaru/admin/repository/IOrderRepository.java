package com.ksimeo.nazaru.admin.repository;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.List;

/**
 * Created by @author Ksimeo on 23.04.2016 at 17:17. For project: Givorost.
 */
public interface IOrderRepository {

    Order save(Order order) throws Exception;
    Order findOne(int id) throws Exception;
    Parcel findSomemany(int page) throws Exception;
    List<Order> findInterval(int from, int to) throws Exception;
    List<Order> findAll() throws Exception;
    void delete(int id) throws Exception;
    void setViewedStatus(int id) throws Exception;
}