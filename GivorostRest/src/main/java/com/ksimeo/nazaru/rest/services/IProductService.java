package com.ksimeo.nazaru.rest.services;

import com.ksimeo.nazaru.core.models.Product;

import java.util.List;

/**
 * Created by @author Ksimeo on 26.01.2015.
 */
public interface IProductService {

    Product saveOne(Product prod);

    List<Product> getAll();

    void delOne(int id);

    void deleteAll();

    Product getById(int id);

    void editOne(Product prod);
}