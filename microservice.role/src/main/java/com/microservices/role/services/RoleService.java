package com.microservices.role.services;

import com.microservices.role.DTO.UserDTO;
import com.microservices.role.clientFeign.IUserClientFeign;
import com.microservices.role.entities.Role;
import com.microservices.role.http.response.UserByRole;
import com.microservices.role.repositories.IRolREpository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {


    @Autowired
    private IRolREpository iRoleRepository;

    @Autowired
    private IUserClientFeign msvcUser;

    @Override
    public List<Role> findAll() {
        return iRoleRepository.findAll();
    }

    @Override
    public Role findById(Long id) {
        Optional<Role> optionalRole = iRoleRepository.findById(id);
        return optionalRole.orElse(null); // Devuelve el objeto Role si está presente, o null si no lo está
    }


    @Override
    public void save(Role role) {
        iRoleRepository.save(role);
    }

    @Override
    public UserByRole finUsersByRol(Long idRol) {
        //consultar el rol
        Role role =  iRoleRepository.findById(idRol).orElse(new Role());

        //obetner los usuarios de ese rol 
        List<UserDTO> userDTOList =  msvcUser.getUsersByRol(idRol);
        return  UserByRole.builder()
            .rolName(role.getName())
            .usersDTOList(userDTOList)
            .build();
    }
}
