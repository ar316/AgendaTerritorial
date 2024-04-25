package com.microservices.role.services;

import com.microservices.role.entities.Role;

import java.util.List;

public interface IRoleService {

    List<Role> findAll();


    Role findById(Long id);

    void save(Role role);
}
