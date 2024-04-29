package com.microservices.role.http.response;

import com.microservices.role.DTO.UserDTO;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserByRole {

    private String rolName;
    private List<UserDTO> usersDTOList;
}
