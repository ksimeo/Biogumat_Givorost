package com.ksimeo.nazaru.admin.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by @author Ksimeo on 30.03.2015
 */
@WebServlet(urlPatterns = "/logout.do")
public class LogOutCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession(false);
            if (session != null) {
                session.removeAttribute("user");
                session.invalidate();
            }
            resp.sendRedirect("/index.jsp");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}