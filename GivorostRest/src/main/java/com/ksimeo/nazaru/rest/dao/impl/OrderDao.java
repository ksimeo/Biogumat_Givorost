package com.ksimeo.nazaru.rest.dao.impl;

import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.rest.dao.config.ConnectionConfig;
import com.ksimeo.nazaru.rest.dao.mocks.IOrderDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by @Ksimeo on 24.04.2015
 */
public class OrderDao {

    public List<Order> getPage(int from, int to) {
        List<Order> page = new ArrayList<>();
        int count = 0;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs;

        try {
            try {

                conn = DriverManager.getConnection(ConnectionConfig.mConnString, ConnectionConfig.dbConnName, ConnectionConfig.dbConnPass);
                ps = conn.prepareStatement(
                        "SELECT COUNT(id) AS m FROM givorostdb.orders");
                rs = ps.executeQuery();
                if (rs.next()) {
                    count = rs.getInt("m");
                }

                if (from <= count) {
                    ps = conn.prepareStatement(
                            "SELECT * FROM givorostdb.orders ORDER BY id DESC LIMIT ?, ?");
                    ps.setInt(1,  from);
                    ps.setInt(2, to);
                    rs = ps.executeQuery();
                    Date sd;
                    Date ed;
                    while (rs.next()) {
                        try
                        {
                            sd = new Date(rs.getTimestamp("start_date").getTime());
                        } catch (NullPointerException e)
                        {
                            sd = null;
                        }
                        try
                        {
                            ed = new Date(rs.getTimestamp("end_date").getTime());
                        } catch (NullPointerException e)
                        {
                            ed = null;
                        }

                        Order order = new Order(rs.getInt("id"),
                                rs.getDate("date"),
                                rs.getString("name"),
                                rs.getString("tel"),
                                rs.getString("email"),
                                rs.getString("region"),
                                rs.getString("productName"),
                                rs.getLong("number"));
                        page.add(order);
                    }

                } else {
                    page = new ArrayList<>();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            if (conn != null) {
                conn = null;
            }
            if (ps != null) {
                ps = null;
            }
        }
        return page;
    }

}
