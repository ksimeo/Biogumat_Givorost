package com.ksimeo.nazaru.admin.controllers.old;

import com.ksimeo.nazaru.admin.services.IOrderService;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
import com.ksimeo.nazaru.core.models.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Created by @author Ksimeo on 23.03.2015
 */
//@WebServlet(urlPatterns = "/usersmain.do")
public class UserCtrl extends HttpServlet {

    @Autowired
    private IOrderService orderServ;

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String p = req.getParameter("p");
            int pageNumb;
            if (p != null) pageNumb = Integer.parseInt(p);
            else pageNumb = 0;
            HttpSession session = req.getSession();
            User user = (User)session.getAttribute("user");
            String username = user.getName();
            req.setAttribute("username", username);
            Parcel<Order> rows = orderServ.getPage(pageNumb);
            List<Order> orders = rows.getPage();
            User currUsr = (User)session.getAttribute("user");
            String userName = currUsr.getName();
            int page = rows.getCount();
            req.setAttribute("orders", orders);
            req.setAttribute("page", page);
            if (rows.isLast()) req.setAttribute("mark1", "hidden");
            req.getRequestDispatcher("/WEB-INF/adminsmain.jsp").forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "������� ������ ��������� ����� �� �� ������� ��'������� � ��������! \" +\n" +
                    "���� �����, ��������� ����� �����.");
        }
    }
}