package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import com.ksimeo.nazaru.view.requests.OrderRepository;
import com.ksimeo.nazaru.view.requests.impl.OrderRestDao;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @Ksimeo on 18.03.2015
 */
public class OrderDao implements IOrderDao {

    private List<Order> orders;
    private OrderRepository restServer = new OrderRestDao();

    public OrderDao() {
        orders = new ArrayList<>();
        orders.add(new Order(1, "Вася", "+380973234567","jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
        orders.add(new Order(2, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
        orders.add(new Order(3, "Петя", "tyuir@hotmail.com", "+380952238990", "Одесская обл.", "Біогумат типу 3", 13));
        orders.add(new Order(4, "Серега", "kkrty@gmail.com", "+380997750544", "Черкасская обл.", "Біогумат типу 1", 7));
        orders.add(new Order(5, "Михаил", "erwer@yahoo.com", "+380500888990", "Харьковская обл.", "Біогумат типу 2", 17));
        orders.add(new Order(6, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
        orders.add(new Order(7, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
        orders.add(new Order(8, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
        orders.add(new Order(9, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
        orders.add(new Order(10, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
        orders.add(new Order(11, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
        orders.add(new Order(12, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
        orders.add(new Order(13, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
        orders.add(new Order(14, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
        orders.add(new Order(15, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
        orders.add(new Order(16, "Макс", "+380500888990", "maks@in.ua", "Харьковская обл.", "Біогумат типу 3", 22));
        orders.add(new Order(17, "Макс", "+380500888990", "maks@in.ua", "Харьковская обл.", "Біогумат типу 3", 24));
        orders.add(new Order(18, "Макс", "+380500888990", "maks@in.ua", "Харьковская обл.", "Біогумат типу 3", 25));
    }


    @Override
    public void saveOrder(Order order) {
//        orders.add(order);
//        restServer.sendOrder(order);
    }

    @Override
    public List<Order> getOrders() {
        return orders;
    }

    @Override
    public Parcel<Order> getOrdersPage(int id) {
        List<Order> ordersPage = new ArrayList<>();


        if (id == 1) {
//            ordersPage.add(new Order(1, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
//            ordersPage.add(new Order(2, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
//            ordersPage.add(new Order(3, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
//            ordersPage.add(new Order(4, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
//            ordersPage.add(new Order(5, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
            return new Parcel<Order>(1, ordersPage, false);
        } else if (id == 2) {
//            ordersPage.add(new Order(6, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
//            ordersPage.add(new Order(7, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
//            ordersPage.add(new Order(8, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
//            ordersPage.add(new Order(9, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
//            ordersPage.add(new Order(10, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
            return new Parcel<Order>(2, ordersPage, false);
        } else {
//            ordersPage.add(new Order(11, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
//            ordersPage.add(new Order(12, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
//            ordersPage.add(new Order(13, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
//            ordersPage.add(new Order(14, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
//            ordersPage.add(new Order(15, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
            return new Parcel<Order>(3, ordersPage, true);
        }
    }

    @Override
    public Parcel<Order> getOrdersPage() {

        List<Order> ordersPage = new ArrayList<>();
//            ordersPage.add(new Order(1, "Вася", "+380973234567", "jwg@mail.com", "Днепропетровщина", "Біогумат типу 1", 43));
//            ordersPage.add(new Order(2, "Коля", "+380637657889", "if1@inbox.com", "Запорожская обл.", "Біогумат типу 1", 54));
//            ordersPage.add(new Order(3, "Петя", "+380952238990", "tyuir@hotmail.com", "Одесская обл.", "Біогумат типу 3", 13));
//            ordersPage.add(new Order(4, "Серега", "+380997750544", "kkrty@gmail.com", "Черкасская обл.", "Біогумат типу 1", 7));
//            ordersPage.add(new Order(5, "Михаил", "+380500888990", "erwer@yahoo.com", "Харьковская обл.", "Біогумат типу 2", 17));
        return new Parcel<Order>(1, ordersPage, false);
    }


    @Override
    public List<Order> getPage(int from, int to) {


        List<Order> toSend = new ArrayList<>();
        if (from < orders.size()) {
            int i = from;
            while (i <= to) {
                if (i < orders.size()) {
                    toSend.add(orders.get(i));
                    i++;
                } else break;
            }
        }
        return toSend;
    }

    @Override
    public int getLastId() {
        return orders.size() - 1;
    }

    public Order getOrder(int id) {

        return null;
//        return restSys.getOrderById(id);
    }
}
