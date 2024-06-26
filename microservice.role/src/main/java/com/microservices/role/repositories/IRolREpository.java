package com.microservices.role.repositories;

import com.microservices.role.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRolREpository extends JpaRepository<Role, Long> {



}
