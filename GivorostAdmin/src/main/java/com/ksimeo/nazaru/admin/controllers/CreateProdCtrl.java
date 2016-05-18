package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IProductService;
import com.ksimeo.nazaru.core.models.Product;
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
 * @author Created by Ksimeo on 08.04.2015
 * @version 1.5
 */
@WebServlet(urlPatterns = "/createprod.ado")
public class CreateProdCtrl extends HttpServlet {

    @Autowired
    private IProductService prodServ;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("WEB-INF/createprod.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String name = req.getParameter("prodname");
            String prodPrice = req.getParameter("price");
            String prodFactor = req.getParameter("factor");
            if (
                name != null && !name.equals("") &&
                prodPrice != null && !prodPrice.equals("") &&
                name != null && !name.equals("")
                    ) {
                try {
                    float price = Float.parseFloat(prodPrice);
                    float factor = Float.parseFloat(prodFactor);
                    if (price == 0f || factor == 0f) throw new NumberFormatException("В одном из полей введено " +
                            "некорректное значение '0f'!");
                    Product product = new Product(name, price, factor);
                    prodServ.addProduct(product);
                    resp.sendRedirect("/products.ado");
                } catch (NumberFormatException e) {
                    req.setAttribute("prodtname", name);
                    req.setAttribute("price", prodPrice);
                    req.setAttribute("factor", prodFactor);
                    req.setAttribute("error", "Ви ввели некоректні дані!");
                    req.getRequestDispatcher("WEB-INF/createprod.jsp").forward(req, resp);
                } catch (Exception e) {
                    e.printStackTrace();
                    req.setAttribute("prodtname", name);
                    req.setAttribute("price", prodPrice);
                    req.setAttribute("factor", prodFactor);
                    req.setAttribute("error", "На сервері виникли технічні негаразди! Будь ласка, спробуйте ще раз пізніше!");
                    req.getRequestDispatcher("WEB-INF/createprod.jsp").forward(req, resp);
                }
            } else {
                req.setAttribute("prodtname", name);
                req.setAttribute("price", prodPrice);
                req.setAttribute("factor", prodFactor);
                req.setAttribute("error", "Ви не заповнили усі поля!");
                req.getRequestDispatcher("WEB-INF/createprod.jsp").forward(req, resp);
            }
        } catch (Exception e) {

            req.setAttribute("error", "Виникли технічні негаразди через які не вдається зв'язатися з сервером! " +
                    "Будь ласка, спробуйте зайти пізніше!");
            req.getRequestDispatcher("WEB-INF/createprod.jsp").forward(req, resp);
        }
    }
}