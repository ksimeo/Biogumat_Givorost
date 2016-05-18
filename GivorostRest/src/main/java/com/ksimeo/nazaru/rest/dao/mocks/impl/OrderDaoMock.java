package com.ksimeo.nazaru.rest.dao.mocks.impl;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import com.ksimeo.nazaru.rest.dao.mocks.IOrderDao;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo on 30.04.2016 at 19:58. For project: Givorost.
 */
@Repository
public class OrderDaoMock implements IOrderDao {

    Order ord1;
    Order ord2;
    Order ord3;
    List<Order> page1;
    List<Order> page2;
    List<Order> page3;

    public OrderDaoMock() {

        ord1 = new Order("Иван", "0972345678", "sfsdf@fdgdfg.com", "Донецк", "Биогумат тип 1", 223);
        ord2 = new Order("Михайло", "0933455689", "sdfs@fdgdf.vo,", "Полтава", "Биогумат тип 2", 3);
        ord3 = new Order("Петро", "0992345667", "dfg@dg.tyu", "Тернопиль", "Биогумат тип 3", 45);
        page1 = new ArrayList<>(Parcel.MAX_ROWS_NUMBERS);
        page2 = new ArrayList<>(Parcel.MAX_ROWS_NUMBERS);
        page3 = new ArrayList<>(Parcel.MAX_ROWS_NUMBERS/2);
        page1.add(ord1);
        page1.add(ord2);
        page1.add(ord3);
        page1.add(ord1);
        page1.add(ord2);
        page1.add(ord3);
        page1.add(ord1);
        page1.add(ord2);
        page2.add(ord3);
        page2.add(ord2);
        page2.add(ord1);
        page2.add(ord3);
        page2.add(ord2);
        page2.add(ord1);
        page2.add(ord3);
        page2.add(ord2);
        page3.add(ord2);
        page3.add(ord3);
        page3.add(ord1);
        page3.add(ord2);
    }

    @Override
    public Parcel getSomemany(int numb) {
        if (numb == 1) return new Parcel(numb, page1, true);
        if (numb == 2) return new Parcel(numb, page2, true);
        if (numb == 3) return new Parcel(numb, page3, false);
        return null;
    }

    @Override
    public List<Order> getPage(int from, int to) {

        return page1;
    }
}
