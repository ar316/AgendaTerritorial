package com.microservices.role.DTO;

import jakarta.persistence.Column;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {




    private String name;

    private String lastname;

    private String identify;

    private String phone;

    private String address;

    private String email;

    private String password;

    private Long rolId;

}
