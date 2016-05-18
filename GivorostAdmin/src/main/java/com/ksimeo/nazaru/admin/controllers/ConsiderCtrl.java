package com.ksimeo.nazaru.admin.controllers;

import com.amazonaws.util.json.JSONObject;
import com.ksimeo.nazaru.admin.helpers.CommonHelper;
import com.ksimeo.nazaru.admin.services.IOrderService;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * @author Ksimeo. Created on 11.05.2016 at 17:32 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/consider.do")
public class ConsiderCtrl extends HttpServlet {

    @Autowired
    private IOrderService orderServ;

    private Logger log =  Logger.getLogger(ConsiderCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            String orderID = req.getParameter("orderId");
            int orderId = 0;
            if (orderID != null) orderId = Integer.parseInt(orderID);
            log.info("Получен ID рассматриваемого объекта.");
            Order order = orderServ.getOrder(orderId);
            order.setConsiderDate(new Date());
            HttpSession session = req.getSession();
            User currUsr = (User) session.getAttribute("user");
            order.setConsiderLogin(currUsr.getLogin());
            orderServ.addOrder(order);
            log.info("Произошло изменение заказа.");
            JSONObject obj = new JSONObject();
            obj.put("date", CommonHelper.correctDateFormat(order.getConsiderDate()));
            obj.put("login", order.getConsiderLogin());
            resp.getWriter().println(obj);
        } catch (Exception e) {
            log.error("Произошла ошибка!");
            e.printStackTrace();
        }
    }
}