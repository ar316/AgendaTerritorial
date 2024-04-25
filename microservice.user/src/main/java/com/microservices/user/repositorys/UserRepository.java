package com.microservices.user.repositorys;


import com.microservices.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



    List<User> findAll();

    User findById(Long id);

    User findByRolId(Long rolId);

    void deleteById(Long id);

    User save(User user);


}
