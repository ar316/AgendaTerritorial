package com.microservices.role.clientFeign;

import com.microservices.role.DTO.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "msvc-user", url = "localhost:8090/api/users")
public interface IUserClientFeign {

    @GetMapping("/search-by-role/{id}")
    List<UserDTO> getUsersByRol(@PathVariable Long id);
}
