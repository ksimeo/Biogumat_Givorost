package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IProductService;
import com.ksimeo.nazaru.core.models.Product;
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
 * Created by @author Ksimeo on 06.04.2015
 */
@WebServlet(urlPatterns = "/products.ado")
public class ProdsCtrl extends HttpServlet {

    @Autowired
    private IProductService prodServ;

    private Logger log = org.apache.log4j.Logger.getLogger(ProdsCtrl.class);

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    /**
     * ������ ����� ������������ ������� ������������ �� �������� � ����������� ������� ������� ������������ ��������
     * �� ��������� ����������� ����������� (�������� ������ ��� ������������� ���������� �������� "�������������").
     *
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            List<Product> products = prodServ.getProducts();
            log.info("Получен список продуктов.");
            HttpSession session = req.getSession();
            User currUsr = (User)session.getAttribute("user");
            req.setAttribute("usrlogin", currUsr.getLogin());
            req.setAttribute("products", products);
            req.getRequestDispatcher("WEB-INF/products.jsp").forward(req, resp);
        } catch(Exception e) {
            log.error("Возникла ошибка.");
            e.printStackTrace();
        }
    }
}