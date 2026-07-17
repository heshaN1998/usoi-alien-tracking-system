package com.soft_universe.tranneer.dtos;

import com.soft_universe.tranneer.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
private Long id;
private String userName;
private Role role;

}
