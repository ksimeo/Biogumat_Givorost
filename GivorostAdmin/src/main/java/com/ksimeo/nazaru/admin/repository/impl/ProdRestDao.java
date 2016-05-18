package com.ksimeo.nazaru.admin.repository.impl;

import com.ksimeo.nazaru.admin.repository.IProductRepository;
import com.ksimeo.nazaru.core.models.Product;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendGet;
import static com.ksimeo.nazaru.admin.helpers.RestRequestsHelper.sendPost;

/**
 * Created by @author Ksimeo on 25.04.2016 at 15:35. For project: Givorost.
 */
@Repository
public class ProdRestDao implements IProductRepository {

    private String urlBase = "http://localhost:6060/";

    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void save(Product prod) throws Exception {

        String fullURL = urlBase + "addprod";
        String data = mapper.writeValueAsString(prod);
//        data = new String(data.getBytes("utf-8"), "ISO-8859-1");
        sendPost(fullURL, data);
//        return mapper.readValue(echo, Product.class);
    }

    @Override
    public Product check(Product prod) throws Exception {
        return null;
    }

    @Override
    public Product findOne(int id) throws Exception {

        String fullURL = urlBase + "getprodbyid/" + id;
        String echo = sendGet(fullURL);
//        Product result = mapper.readValue(echo, Product.class);
        return mapper.readValue(echo, Product.class);
    }

    @Override
    public Product findOne(String login) throws Exception {
        return null;
    }

    @Override
    public List<Product> findAll() throws Exception {

        String fullURL = urlBase + "getprods";
        String echo = sendGet(fullURL);
        List<Product> result = mapper.readValue(echo, new TypeReference<List<Product>>() {} );
        return result;
    }

    @Override
    public void delete(int id) throws Exception {

        String fullURL = urlBase + "delprod/" + id;
        sendGet(fullURL);
    }
}
