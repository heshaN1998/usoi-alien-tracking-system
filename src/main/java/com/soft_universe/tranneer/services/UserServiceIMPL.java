package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.UserRequestDTO;
import com.soft_universe.tranneer.dtos.UserResponseDTO;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceIMPL implements UserService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceIMPL(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;

    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        return null;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return List.of();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        return null;
    }

    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }
}
