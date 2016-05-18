package com.ksimeo.nazaru.view.services;

import com.ksimeo.nazaru.core.models.Product;
import com.ksimeo.nazaru.view.requests.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Created by Ksimeo on 13.03.2015
 */
@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productrRepository;


    @Override
    public List<Product> getAllProducts() {

        List<Product> toSend = (List<Product>) productrRepository.getProducts();
        return toSend;
    }

//    @Override
//    public Product getProductById(int id) {
//
//        return productrRepository.getProductById(id);
//    }
}
