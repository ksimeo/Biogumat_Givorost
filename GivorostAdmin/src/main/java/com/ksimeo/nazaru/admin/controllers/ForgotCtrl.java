package com.ksimeo.nazaru.admin.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author Ksimeo. Created on 03.05.2016 at 16:23 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */

//TODO Реализовать сервлет обрабатывающий запросы пользователя в случае необходимости восстановления пароля.

@WebServlet(urlPatterns = "/forgotpassw")
public class ForgotCtrl extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("WEB-INF/forgotpassw.jsp").forward(req, resp);
    }
}
