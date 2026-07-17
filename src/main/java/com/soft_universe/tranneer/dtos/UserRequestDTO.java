package com.soft_universe.tranneer.dtos;

import com.soft_universe.tranneer.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
private String userName;
private String password;
private Role role;

}
