package com.microservices.user.repositorys;


import com.microservices.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    Optional<User> findById(Long id);

    List<User> findByRolId(Long rolId);

    void deleteById(Long id);

    User save(User user);
}
