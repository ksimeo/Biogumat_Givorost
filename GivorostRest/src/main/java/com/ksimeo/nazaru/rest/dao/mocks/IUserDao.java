package com.ksimeo.nazaru.rest.dao.mocks;

import com.ksimeo.nazaru.core.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by @author Ksimeo on 26.01.2015.
 */
//@Repository
public interface IUserDao extends CrudRepository<User, Integer> {

    @Query(value = "SELECT * FROM users WHERE login=:login", nativeQuery=true)
    public User findByLogin(@Param("login") String login);
}