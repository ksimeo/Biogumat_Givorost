package com.ksimeo.nazaru.rest.dao.mocks;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.List;

/**
 * Created by @author Ksimeo on 30.04.2016 at 19:05. For project: Givorost.
 */
public interface IOrderDao {

    Parcel getSomemany(int numb);
    List<Order> getPage(int from, int to);
}
