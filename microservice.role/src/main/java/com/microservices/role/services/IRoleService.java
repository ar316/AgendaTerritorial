package com.microservices.role.services;

import com.microservices.role.entities.Role;
import com.microservices.role.http.response.UserByRole;

import java.util.List;

public interface IRoleService {


    List<Role> findAll();

    Role findById(Long id);

    void save(Role role);

    UserByRole finUsersByRol(Long idRol);
}
