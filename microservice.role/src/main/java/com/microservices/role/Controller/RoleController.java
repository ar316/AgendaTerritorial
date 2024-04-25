package com.microservices.role.Controller;


import com.microservices.role.entities.Role;
import com.microservices.role.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/rols")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping("/getUsers")
    public List<Role> getUsers() {
        return roleService.findAll();
    }

    @PostMapping("/create")
    public void create(@RequestBody Role user){
        roleService.save(user);
    }



}
