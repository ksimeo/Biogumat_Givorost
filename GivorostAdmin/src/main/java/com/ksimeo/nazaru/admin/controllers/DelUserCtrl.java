package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IUserService;
import com.ksimeo.nazaru.core.models.User;
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

/**
 * Created by @author Ksimeo on 07.04.2015
 */
@WebServlet(urlPatterns = "/delusr.ado")
public class DelUserCtrl extends HttpServlet {

    @Autowired
    private IUserService userServ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * Данный метод выполняет удаление пользователя системы администрирования приложения (доступно только пользователю
     * с правами администратора системы). Перед удалением происходит проверка на предмет, не пытается ли пользователь
     * удалить самого себя из списка пользователей системы (в случае этого возникала бы некоторая коллизия в системе).
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("application/json");
            resp.setContentType("text/html; charset=UTF-8");
            String userid = req.getParameter("id");
            int userId = 0;
            if (userid != null) userId = Integer.parseInt(userid);
            HttpSession session = req.getSession();
            User curUser = (User) session.getAttribute("user");
            int curUsrId = curUser.getId();
            if (userId != curUsrId) {
                userServ.delUser(userId);
                resp.sendRedirect("/users.ado");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}