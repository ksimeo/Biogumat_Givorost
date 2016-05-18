package com.ksimeo.nazaru.rest.services.impl;

import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.rest.dao.ProductRepository;
import com.ksimeo.nazaru.rest.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by @author Ksimeo on 26.01.2015
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository prodDao;

    @Override
    public Product saveOne(Product prod) {
//        int lastId = getLastId();
//        prod.setId(++lastId);
        return prodDao.save(prod);
    }

    @Override
    public List<Product> getAll() {

        return (List<Product>) prodDao.findAll();
    }

    @Override
    public void delOne(int id) {

        prodDao.delete(id);
    }

    @Override
    public void deleteAll() {

        prodDao.deleteAll();
    }

    @Override
    public Product getById(int id) {

        return prodDao.findOne(id);
    }

    @Override
    public void editOne(Product product) {

        prodDao.delete(product.getId());
        prodDao.save(product);
    }

//    private int getMaxId() {
//        List<Product> prods = (List<Product>) prodDao.findAll();
//        int maxId = 0;
//        for (Product prod : prods) {
//            if (prod.getId() > maxId) maxId = prod.getId();
//        }
//        return maxId;
//    }
}
