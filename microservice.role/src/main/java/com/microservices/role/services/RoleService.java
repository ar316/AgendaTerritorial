package com.microservices.role.services;

import com.microservices.role.entities.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService implements IRoleService {



    @Autowired
    private IRoleService iRoleService;


    @Override
    public List<Role> findAll() {
        return iRoleService.findAll();
    }

    @Override
    public Role findById(Long id) {
        return iRoleService.findById(id);
    }

    @Override
    public void save(Role role) {
        iRoleService.save(role);
    }
}
