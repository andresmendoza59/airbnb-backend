package co.edu.udemedellin.airbnb_backend.dto;

import co.edu.udemedellin.airbnb_backend.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Role role;
}
