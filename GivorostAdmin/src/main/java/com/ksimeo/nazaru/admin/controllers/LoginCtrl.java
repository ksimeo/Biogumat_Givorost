package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IUserService;
import com.ksimeo.nazaru.core.models.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author Created by Ksimeo on 18.03.2015
 * @version 1.5
 *
 * Данный класс представляет контроллер обрабатывающий запросы со стартовой страницы входа в администрирование всем
 * приложением.
 */
@WebServlet(urlPatterns = "/login")
public class LoginCtrl extends HttpServlet {


    @Autowired
    private IUserService usrServ;

    private static final Logger log = Logger.getLogger(LoginCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * Данный метод сначала производит валидацию заполнения формы отправленной пользователем, после чего, выполняет
     *  запрос к БД и производит проверку соответсвия введённых логина и пароля на соответствие их одному
     * из пользователей зарегистрированных раннее в системе. Если, авторизация выполняется успешно, т.е. пользователь
     * с точно таким же логином действительн существует в системе и введенный пароль верен, то выполняется
     * переход на одну из версий главной страницы администрирования проекта (администратора или пользователя системы,
     * в зависимости от статуса указанного в свойствах пользователя) Если, пользователя с таким логином не существует
     * или пароль был введен не верно, пользователь остается на странице, и его просят продублировать введение логина
     * и пароля.
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */

    //TODO Предусмотреть в будущем локализацию приложения.

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            String login = req.getParameter("login");
            String password = req.getParameter("password");
            String lang = req.getParameter("lang");
            log.info("Получены пароль и логин пользователя!");
            boolean isFullForm = true;
            if (null == login || login.isEmpty()) isFullForm = false;
            if (null == password || password.isEmpty()) isFullForm = false;
            if (isFullForm) {
                User usr = usrServ.getUser(login, password);
                if (usr != null) {
                    HttpSession session = req.getSession();
                    session.setAttribute("user", usr);
                    session.setAttribute("lang", lang);
                    session.setMaxInactiveInterval(30 * 60);
                    String name = usr.getLogin();
                    Cookie userLogin = new Cookie("user", name);
                    userLogin.setMaxAge(30 * 60);
                    resp.addCookie(userLogin);
                    resp.sendRedirect("/main.do?p=1");
                } else {
                    req.setAttribute("error", "Ви ввели помілковий логін або пароль!");
                    log.error("Пароль оказался неверным или логина не существует");
                    req.getRequestDispatcher("/index.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Ви не заповнили усі поля!");
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.err.println("Возникла ошибка в ходе выполнения контроллера LoginCtrl");
            req.setAttribute("error", "Виникли технічні негаразди через які не вдається зв'язатися з сервером! " +
                    "Будь ласка, спробуйте зайти пізніше.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}