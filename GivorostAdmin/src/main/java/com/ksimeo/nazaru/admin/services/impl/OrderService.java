package com.ksimeo.nazaru.admin.services.impl;

import com.ksimeo.nazaru.admin.repository.IOrderRepository;
import com.ksimeo.nazaru.admin.services.IOrderService;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Ksimeo on 18.03.2015
 * @version 2.6
 * @since 1.0
 */
@Service
public class OrderService implements IOrderService {

    private static List<Order> orders;

    private static List<Parcel<Order>> parcels;

    @Autowired
    private IOrderRepository orderDao;

    @Override
    public void addOrder(Order order) throws Exception {

        orderDao.save(order);

//        throw new UnsupportedOperationException();
    }

    @Override
    public Order getOrder(int id) throws Exception {

        for (Order order : orders) {
            if (order.getId() == id)
                return order;
        }
//        return orderDao.findOne(id);
        return null;
    }

    @Override
    public List<Order> getOrders() throws Exception {

       return orderDao.findAll();
    }

    @Override
    public Parcel<Order> getPage(int page) throws Exception {
//        update();
//        System.out.println(parcels);
        update();
        return parcels.get(page - 1);

//        int valume = Parcel.MAX_ROWS_NUMBERS;
//        int from = (page - 1)*valume + 1;
//        int to = from + valume - 1;
//        List<Order> result = orderDao.findInterval(from, to);
//        boolean isLast = result.size() != Parcel.MAX_ROWS_NUMBERS;
//        return new Parcel<>(page, result, isLast);
    }

    public void update() {
        try {
            orders = orderDao.findAll();
            int rowNumb = orders.size();
            List<Parcel<Order>> result = new ArrayList<>();
            int pageValume = Parcel.MAX_ROWS_NUMBERS;
            List<Order> page = new ArrayList<>();
            int numb = 0;
            int pageNumb = 1;
            for (int i = rowNumb; i > 0; i--) {
                if (numb < pageValume) {
                    page.add(orders.get(i - 1));
                    numb++;
                } else {
                    result.add(new Parcel<>(pageNumb++, page, i == rowNumb - 1));
                    page = new ArrayList<>();
                    numb = 0;
                }
            }
            result.add(new Parcel<>(pageNumb, page, true));
            parcels = result;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delOrder(int id) throws Exception {

        orderDao.delete(id);
    }

    @Override
    public void setAsViewed(int id) throws Exception {

        orderDao.setViewedStatus(id);
    }
}