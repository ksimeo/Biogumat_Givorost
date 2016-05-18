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
import java.io.IOException;

/**
 * Created by @author Ksimeo on 08.04.2015
 */
@WebServlet(urlPatterns = "/createusr.ado")
public class CreateUserCtrl extends HttpServlet {

    @Autowired
    private IUserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * Данный метод обрабатывает запрос от пользователя и переадресовывает его на страницу создания и добавления
     * пользователя в систему администрирования (доступно только пользователям со статусом администратора).
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

            req.getRequestDispatcher("WEB-INF/createusr.jsp").forward(req, resp);
    }

    /**
     * Данный метод обрабатывает запрос от пользователя на добавление нового пользователя в систему администрирования
     * (доступно только для пользователя со статусом администратора). Предварительно выполняет валидацию заполненности
     * всех полей формы и выполняет проверку уникальности нового логина в БД системы. В случае успешного добавления,
     * возвращает на обновленную страницу со списком пользователей системы.
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
            String name = req.getParameter("username");
            String login = req.getParameter("userlogin");
            String password = req.getParameter("pass1");
            String adminStatus = req.getParameter("adminstatus");
            String email = req.getParameter("email");
            if (
                    name != null && !name.equals("") &&
                            login != null && !login.equals("") &&
                            password != null && !password.equals("") &&
                            email != null && !email.equals("")
                    ) {
                boolean isAdmin = Boolean.parseBoolean(adminStatus);
                if (!userService.isLoginExist(login)) {
                    User user = new User(name, login, password, email, isAdmin);
                    userService.addUser(user);
                    resp.sendRedirect("/users.ado");
                } else {
                    req.setAttribute("error", "Такий логiн вже існує!");
                    req.getRequestDispatcher("WEB-INF/createusr.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("error", "Ви не заповнили усі поля!");
                req.getRequestDispatcher("WEB-INF/createusr.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            req.setAttribute("error", "Виникли технічні негаразди через які не вдається зв'язатися з сервером!" +
                    "Будь ласка, спробуйте зайти пізніше.");
            req.getRequestDispatcher("WEB-INF/createusr.jsp").forward(req, resp);
        }
    }
}