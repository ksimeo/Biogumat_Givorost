package com.ksimeo.nazaru.rest.dao.mocks;

import com.ksimeo.nazaru.core.models.Product;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ksimeo on 26.01.2015.
 */
//@Repository
public interface IProductDao extends CrudRepository<Product, Integer> {

}