package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IUserService;
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
import java.util.List;


/**
 * @author Ksimeo on 18.03.2015
 * @version 2.5
 * @since 1.0
 */
@WebServlet(urlPatterns = "/users.ado")
public class UsersCtrl extends HttpServlet {

    @Autowired
    private IUserService userServ;

    private Logger log = Logger.getLogger(UsersCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html; charset=UTF-8");
            req.getRequestDispatcher("WEB-INF/users.jsp").forward(req, resp);
            List<User> users = userServ.getUsers();
            log.info("Получен список пользователей из системы.");
            HttpSession session = req.getSession();
            User currUsr = (User)session.getAttribute("user");
            req.setAttribute("usrlogin", currUsr.getLogin());
            req.setAttribute("users", users);
            req.setCharacterEncoding("UTF-8");

        } catch(Exception e) {
            log.error("Возникла ошибка при выполнении контроллера.");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { }
}
