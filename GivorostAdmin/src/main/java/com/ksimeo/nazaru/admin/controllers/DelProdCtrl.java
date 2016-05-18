package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IProductService;
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
 * Created by  @author Ksimeo on 10.04.2015
 */
@WebServlet(urlPatterns = "/delprod.ado")
public class DelProdCtrl extends HttpServlet {

    @Autowired
    private IProductService prodServ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String prodid = req.getParameter("id");
            int id = Integer.parseInt(prodid);
            prodServ.delProduct(id);
            resp.sendRedirect("/products.ado");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}