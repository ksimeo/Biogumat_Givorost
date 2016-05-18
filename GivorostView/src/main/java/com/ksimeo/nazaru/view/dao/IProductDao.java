package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.Product;

import java.util.List;

/**
 * Created by @Ksimeo on 17.03.2015
 */
public interface IProductDao {

    List<Product> getAllProducts();
    Product getProduct(int id);
    void replaceProd(Product prod);
    void delProduct(int id);
}