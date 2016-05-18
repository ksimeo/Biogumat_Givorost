package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IOrderService;
import com.ksimeo.nazaru.core.models.Order;
import com.ksimeo.nazaru.core.models.Parcel;
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
 * @author Ksimeo. Created on 03.05.2016 at 13:51 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */
@WebServlet(urlPatterns = "/main.do")
public class MainCtrl extends HttpServlet {

    @Autowired
    private IOrderService orderServ;

    private static final Logger log = Logger.getLogger(MainCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * Данный метод сервлета обрабатывает запрос браузера на перенаправление пользователя на главную страницу
     * администрирования ресурса на которой располагается журнал поступивших заказов от клиентов. При этом,
     * предварительно происходит проверка статуса пользователя, после чего перенаправление происходит
     * на необходимую версию страницы (администратор или пользователь).
     *
     * @param req
     * @param resp
     */

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String p = req.getParameter("p");
            log.info("Был получен номер страницы журнала заказов.");
            int pageNumb;
            if (p != null) pageNumb = Integer.parseInt(p);
            else pageNumb = 0;
            HttpSession session = req.getSession();
            User currUsr = (User)session.getAttribute("user");
            log.info("Был получен объект пользователя из сессии.");
            String username = currUsr.getName();
            String login = currUsr.getLogin();
            req.setAttribute("username", username);
            req.setAttribute("usrlogin", login);
//            log.info("");
//            if (pageNumb == 1) orderServ.update();
            Parcel<Order> rows = orderServ.getPage(pageNumb);
            List<Order> orders = rows.getPage();
            log.info("Получена страница заказов.");
            currUsr = (User)session.getAttribute("user");
            int page = rows.getCount();
            req.setAttribute("orders", orders);
            req.setAttribute("page", page);
            if (rows.getCount() == 1) req.setAttribute("mark1", "hidden");
            if (rows.isLast()) req.setAttribute("mark2", "hidden");
            if (!currUsr.isAdmin()) req.setAttribute("mark3", "hidden");
            req.getRequestDispatcher("WEB-INF/main.jsp").forward(req, resp);
        } catch(Exception e) {
            e.printStackTrace();
            log.error("Возникла ошибка.");
            req.setAttribute("error", "Виникли технічні негаразди через які не вдається зв'язатися з сервером!" +
                    "Будь ласка, спробуйте зайти пізніше.");
            req.getRequestDispatcher("WEB-INF/main.jsp").forward(req, resp);
        }
    }
}
