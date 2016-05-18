package com.ksimeo.nazaru.admin.services.impl;

import com.ksimeo.nazaru.admin.repository.IProductRepository;
import com.ksimeo.nazaru.admin.services.IProductService;
import com.ksimeo.nazaru.core.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Ksimeo on 13.03.2015
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository prodDao;

    @Override
    public List<Product> getProducts() throws Exception {

        return prodDao.findAll();
    }

    @Override
    public void addProduct(Product prod) throws Exception {

        prodDao.save(prod);
    }

    @Override
    public Product getProduct(int id) throws Exception {

        return prodDao.findOne(id);
    }

    @Override
    public void delProduct(int id) throws Exception {

        prodDao.delete(id);
    }
}
