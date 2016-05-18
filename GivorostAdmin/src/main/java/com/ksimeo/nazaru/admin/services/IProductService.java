package com.ksimeo.nazaru.admin.services;

import com.ksimeo.nazaru.core.models.Product;

import java.util.List;

/**
 * Created by @author Ksimeo on 13.03.2015
 */
public interface IProductService {

    void addProduct(Product prod) throws Exception;
    Product getProduct(int id) throws Exception;
    List<Product> getProducts() throws Exception;
    void delProduct(int id) throws Exception;
}
