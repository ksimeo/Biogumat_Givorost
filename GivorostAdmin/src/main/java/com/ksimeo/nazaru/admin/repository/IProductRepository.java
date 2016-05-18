package com.ksimeo.nazaru.admin.repository;

import com.ksimeo.nazaru.core.models.Product;

import java.util.List;

/**
 * @author Ksimeo on 25.04.2016 at 15:31. For project: Givorost.
 */
public interface IProductRepository {

    void save(Product prod) throws Exception;

    Product check(Product prod) throws Exception;

    Product findOne(int id) throws Exception;

    Product findOne(String login) throws Exception;

    List<Product> findAll() throws Exception;

    void delete(int id) throws Exception;
}
