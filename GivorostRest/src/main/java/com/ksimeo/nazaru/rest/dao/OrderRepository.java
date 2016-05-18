package com.ksimeo.nazaru.rest.dao;

import com.ksimeo.nazaru.core.models.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Ksimeo on 26.01.2015
 * @version 2.5
 * @since 2.5
 */
//@Repository
public interface OrderRepository extends CrudRepository<Order, Integer> {

//    @Query(value="SELECT * FROM givorostdb.orders ORDER BY id DESC LIMIT from=:from, to=:to", nativeQuery=true)
//    public List<Order> getPage(@Param("from")int from, @Param("to")int to);

    @Query(value = "SELECT * FROM givorostdb.orders LIMIT from=:from, to=:to", nativeQuery = true)
    List<Order> getPage(@Param("from") int from, @Param("to") int to);
}