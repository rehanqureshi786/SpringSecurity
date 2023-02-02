package com.security.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.security.app.model.User;

@Repository
public interface UserRepo extends CrudRepository<User, Integer> {

    @Query(value = "SELECT u FROM User u where u.username = ?1 and u.password = ?2 ")
    public Optional<User> login(String username,String password);
    public Optional<User> findByToken(String token);
}