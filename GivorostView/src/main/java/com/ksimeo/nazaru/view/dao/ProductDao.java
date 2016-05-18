package com.ksimeo.nazaru.view.dao;

import com.ksimeo.nazaru.core.models.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @Ksimeo on 17.03.2015
 */
public class ProductDao implements IProductDao {

    private List<Product> products;

    public ProductDao() {
        products = new ArrayList<Product>();
        products.add(new Product(1, "Біогумат першого типу", 100.0f, 0.55f));
        products.add(new Product(2, "Біогумат другого типу", 127.0f, 0.93f));
        products.add(new Product(3, "Біогумат третього типу", 99.99f, 1.23f));
    }

//    @Override
    public List<Product> getAllProducts() {

        return products;
    }

//    @Override
    public Product getProduct(int id) {

        return products.get(id - 1);
    }

//    @Override
    public void replaceProd(Product prod) {

        products.add(prod.getId(), prod);
    }

//    @Override
    public void delProduct(int id) {

        products.remove(id - 1);
    }
}