package com.soft_universe.tranneer.dtos;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.soft_universe.tranneer.entities.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"id","userName","role","createdBy","createdAt","updatedBy","updatedAt"})
public class UserResponseDTO {
private Long id;
private String userName;
private Role role;

private String createdBy;
private String updatedBy;
private LocalDateTime createdAt;
private LocalDateTime updatedAt;

    public UserResponseDTO(Long id, String username, Role role) {
        this.id = id;
        this.userName = username;
        this.role = role;
    }

}
