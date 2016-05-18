package com.ksimeo.nazaru.rest.services.impl;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import com.ksimeo.nazaru.rest.dao.OrderRepository;
import com.ksimeo.nazaru.rest.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Ksimeo on 26.01.2015
 */
@Service
public class OrderService implements IOrderService {

//    @Autowired
//    private IOrderRepository orderDao;

    @Autowired
    private OrderRepository orderDao;

    @Override
    public Order add(Order order) {

        return orderDao.save(order);
    }

    @Override
    public List<Order> getPage(int page) {

        return (List<Order>) orderDao.findAll();
    }

    @Override
    public long getCount() {

        return orderDao.count();
    }

    @Override
    public List<Order> getPage(int from, int to) {

      /*  List<Order> toSend = new ArrayList<>();
        if (from < to) {
            for (int i = to; i >= from; i--) {
                Order order = orderDao.findOne(i);
                if (order == null) continue;
                toSend.add(order);
            }
        } else if (from == to) {
            toSend.add(orderDao.findOne(from));
        }
        return toSend;*/
        /*return orderDao.getPage(from, to);*/

        List<Order> result = (List<Order>) orderDao.findAll();
        int size = result.size();
        if (size != 0) {
            List<Order> toSend = new LinkedList<Order>();
            if (to > size) {
                to = size;
                for (int i = from - 1; i < to; i++) {
                    toSend.add(result.get(i));
                }
                return toSend;
            } else if (to == size) {
                toSend.add(null);
                return toSend;
            } else return null;
        }
        return null;
    }

        @Override
        public List<Order> getAll() {

            return (ArrayList<Order>) orderDao.findAll();
        }

        @Override
        public void deleteAll() {

            orderDao.deleteAll();
        }

        @Override
        public void delete(int id) {

            orderDao.delete(id);
//        List<Order> orders = (List<Order>) orderDao.findAll();
//        orderDao.deleteAll();
//        int i = 1;
//        for (Order order : orders) {
//            order.setId(i++);
//            orderDao.save(order);
//        }
        }

        @Override
        public Parcel getParcel(int page) {

            return null;
//        return orderDao.getSomemany(page);
//        List<Order> orderGroup = getSeveral(page, valume);
//        boolean isLastPage = false;
//        List<Order> nextGroup = getSeveral(page + 1, valume);
//        if (nextGroup == null && nextGroup.isEmpty()) isLastPage = true;
//        return new Parcel<>(page, orderGroup, isLastPage);
//        int from;
//        int to;
//        if (page > maxPage) page = maxPage;
//        if(page > 0) {
//            to = (int) (numb - ((page - 1) * rowNumb));
//            from = to - (rowNumb - 1);
//        } else {
//            page = 1;
//            to = (int) (numb - ((page - 1) * rowNumb));
//            from = to - (rowNumb - 1);
//        }
//        if(from <= 0) from = 1;
//        if (to > numb) to = (int) numb;
        }

//    private int getMaxId() {
//        List<Order> orders = (List<Order>) orderDao.findAll();
//        int maxId = 0;
//        for (Order order : orders) {
//            if (order.getId() > maxId) maxId = order.getId();
//        }
//        return maxId;
//    }

        private List<Order> getSeveral(int page, int valume) {

            int from = (page - 1)*valume + 1;
            int to = from + valume;
            return orderDao.getPage(from, to);
        }
    }