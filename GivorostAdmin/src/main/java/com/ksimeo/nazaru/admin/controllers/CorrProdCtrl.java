package com.ksimeo.nazaru.admin.controllers;

import com.ksimeo.nazaru.admin.services.IProductService;
import com.ksimeo.nazaru.core.models.Product;
import org.apache.log4j.Logger;
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
 * @author Ksimeo on 10.04.2015
 * @version 2.5
 * @since 1.0
 */
@WebServlet(urlPatterns = "/corrprod.ado")
public class CorrProdCtrl extends HttpServlet {

    @Autowired
    private IProductService prodServ;

    private Logger log = Logger.getLogger(CorrProdCtrl.class);


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
            String prodId = req.getParameter("id");
            int id = 0;
            if (prodId != null) id = Integer.parseInt(prodId);
            log.info("Получен ID продукта.");
            Product prod = prodServ.getProduct(id);
            log.info("Получена продукт по ID.");
            String oldName = prod.getName();
            float oldPrice = prod.getPrice();
            float oldFactor = prod.getFactor();
            req.setAttribute("prodid", prodId);
            req.setAttribute("prodname", oldName);
            req.setAttribute("price", oldPrice);
            req.setAttribute("factor", oldFactor);
            req.getRequestDispatcher("WEB-INF/corrprod.jsp").forward(req, resp);
        } catch (Exception e) {
            log.error("Возникла ошибка!");
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            req.setCharacterEncoding("UTF-8");
            resp.setContentType("text/html; charset=UTF-8");
            String prodId = req.getParameter("prodid");
            int id = 0;
            if (prodId != null) id = Integer.parseInt(prodId);
            log.info("Получен ID корректируемого продукта.");
            Product prod = prodServ.getProduct(id);
            log.info("Получен объект корректируемого продукта по полученному ID.");
            String name = req.getParameter("prodname");
            String prodPrice = req.getParameter("price");
            String prodFactor = req.getParameter("factor");
            if (
                    name != null && !name.equals("") &&
                    prodPrice != null && !prodPrice.equals("") &&
                    prodFactor != null && !prodFactor.equals("")
                    ) {
                float price = Float.parseFloat(prodPrice);
                float factor = Float.parseFloat(prodFactor);

                prod.setName(name);
                prod.setPrice(price);
                prod.setFactor(factor);
                log.info("Установлены новые значения полей объекта.");
                prodServ.addProduct(prod);
                log.info("Выполнено сохранение измененного объекта.");
                resp.sendRedirect("/products.ado");
            } else {
                req.setAttribute("prodtname", name);
                req.setAttribute("price", prodPrice);
                req.setAttribute("factor", prodFactor);
                req.setAttribute("error", "Ви не заполнили все поля!");
                log.info("Выявлено неполное заполнение полей.");
                req.getRequestDispatcher("WEB-INF/corrprod.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("Возникла ошибка при выполнении.");
            req.setAttribute("error", "Виникли технічні негаразди через які не вдається зв'язатися з сервером! " +
                    "Будь ласка, спробуйте зайти пізніше!");
            req.getRequestDispatcher("WEB-INF/corrprod.jsp").forward(req, resp);
        }
    }
}
