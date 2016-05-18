package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 18.05.2015
 */
@WebServlet(urlPatterns = "/delorder.ado")
public class DelOrderCtrl extends HttpServlet {

    @Autowired
    private IOrderService ordServ;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String orderId = req.getParameter("orderid");
            String page = req.getParameter("currpage");
            int id = Integer.parseInt(orderId);
            ordServ.delOrder(id);
            resp.sendRedirect("/adminsmain.ado?p=" + page);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
