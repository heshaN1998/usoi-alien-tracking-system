package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.UserRequestDTO;
import com.soft_universe.tranneer.dtos.UserResponseDTO;

import java.util.List;
public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    UserResponseDTO updateUser(Long id, UserRequestDTO dto);
    void deleteUser(Long id);

}
