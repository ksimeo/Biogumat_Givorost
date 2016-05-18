package com.ksimeo.nazaru.rest.dao;

import com.ksimeo.nazaru.core.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * @author Ksimeo on 03.05.2015
 * @version 2.5
 * @since 1.0
 */
//@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE login=:login", nativeQuery = true)
    User findOneByLogin(@Param("login") String login);

    @Query(value = "SELECT * FROM users WHERE email=:email", nativeQuery = true)
    User findOneByEmail(@Param("email") String email);
}