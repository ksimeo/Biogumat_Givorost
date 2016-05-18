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

/**
 * Created by @author Ksimeo on 12.04.2015
 */
@WebServlet(urlPatterns = "/changepassw.do")
public class ChangePasswCtrl extends HttpServlet {

    @Autowired
    private IUserService uServ;

    private Logger log = Logger.getLogger(ChangePasswCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * Данный метод перенаправляет пользователя на страницу смены пароля.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        log.info("Получен запрос на перевод пользователя на страницу смены пароля.");
        req.getRequestDispatcher("WEB-INF/changepassw.jsp").forward(req, resp);
    }

    /**
     * Данный метод принимает данные введенные в форму, выполняет их верификацию и отправляет на сервер.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String oldpassw = req.getParameter("oldpassw");
            String newpassw = req.getParameter("passw");
            log.info("Приняты старый и новый пароль.");
            HttpSession session = req.getSession();
            User usr = (User) session.getAttribute("user");
            log.info("Получен объект пользователя сохраненный в сессии.");
            if (usr != null && oldpassw.equals(usr.getPassword())) {
                usr.setPassword(newpassw);
                uServ.addUser(usr);
                log.info("Сохранен пользователь с измененным паролем.");
                session.setAttribute("user", usr);
                resp.sendRedirect("/main.do");
            } else {
                req.setAttribute("error", "Ви ввели помілковий пароль!");
                req.getRequestDispatcher("WEB-INF/changepassw.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Не сработало!");
        }
    }
}