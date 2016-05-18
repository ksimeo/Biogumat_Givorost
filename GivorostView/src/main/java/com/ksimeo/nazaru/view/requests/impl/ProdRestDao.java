package com.ksimeo.nazaru.view.requests.impl;

import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.view.requests.ProductRepository;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ksimeo.nazaru.view.helpers.RequestHelper.sendGet;

/**
 * @author Ksimeo. Created on 18.05.2016 at 11:19 for "Givorost" project.
 * @version 1.0
 * @since 1.0
 */
@Repository
public class ProdRestDao implements ProductRepository {

    private String urlBase = "http://localhost:6060";

    public List<Product> getProducts() {
        try {
            String fullPath = urlBase + "/getprods";
            String data = sendGet(fullPath);
            data = new String(data.getBytes("cp1251"), "utf-8");
            ObjectMapper om = new ObjectMapper();
            List<Product> toSend = om.readValue(data, new TypeReference<List<Product>>() { });
            return toSend;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}