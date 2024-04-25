package com.microservices.user.services;

import com.microservices.user.entities.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();

    User findById(Long id);

    void save(User user);

    void deleteById(Long id);

    List<User> findByRolId(Long idRol);

}
