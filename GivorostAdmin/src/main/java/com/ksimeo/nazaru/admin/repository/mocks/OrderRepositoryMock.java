package com.ksimeo.nazaru.admin.repository.mocks;

import com.ksimeo.nazaru.admin.repository.IOrderRepository;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @author Ksimeo on 30.04.2016 at 11:18. For project: Givorost.
 */
//@Repository
public class OrderRepositoryMock implements IOrderRepository {

    @Override
    public Order save(Order order) throws Exception {
        return null;
    }

    @Override
    public Order findOne(int id) throws Exception {
        return null;
    }

    @Override
    public Parcel findSomemany(int page) throws Exception {

        Order ord1 = new Order("Иван", "0972345678", "sfsdf@fdgdfg.com", "Донецк", "Биогумат тип 1", 223);
        Order ord2 = new Order("Михайло", "0933455689", "sdfs@fdgdf.vo,", "Полтава", "Биогумат тип 2", 3);
        Order ord3 = new Order("Петро", "0992345667", "dfg@dg.tyu", "Тернопиль", "Биогумат тип 3", 45);
        List<Order> ordr = new ArrayList<>();
        ordr.add(ord1);
        ordr.add(ord2);
        ordr.add(ord3);
        Parcel toSend = new Parcel(1, ordr, true);
        return toSend;
    }

    @Override
    public List<Order> findAll() throws Exception {
        return null;
    }

    @Override
    public void delete(int id) throws Exception {

    }

    @Override
    public void setViewedStatus(int id) throws Exception {

    }

    @Override
    public List<Order> findInterval(int from, int to) throws Exception {
        return null;
    }
}
