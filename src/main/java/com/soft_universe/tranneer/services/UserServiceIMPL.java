package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.UserRequestDTO;
import com.soft_universe.tranneer.dtos.UserResponseDTO;
import com.soft_universe.tranneer.entities.User;
import com.soft_universe.tranneer.exceptions.UserNotFoundException;
import com.soft_universe.tranneer.mapper.DtoEntityMapper;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
    private UserResponseDTO mapToResponse(User user){
        return new UserResponseDTO(user.getId(),user.getUserName(),user.getRole());
    }


    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        long userCount =userRepository.count();
        if(userCount >= 7){
            throw new RuntimeException("USOI system can access only 7 authority.maximum limit reached");
        }

        User user=User.builder()
                .userName(dto.getUserName())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole())
                .build();
        User saved=userRepository.save(user);
        return mapToResponse(saved);
    }


    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll().stream().map(this::mapToResponse).toList();
    }


    @Override
    public UserResponseDTO getUserById(Long id) {
        User user=userRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("user not found"));
        return mapToResponse(user);
    }


    @Override
    public UserResponseDTO updateUser(Long id, UserRequestDTO dto) {
        User user=userRepository.findById(id).orElseThrow(()->new UsernameNotFoundException("user not found"));
        user.setUserName(dto.getUserName());
        user.setRole(dto.getRole());

        if (dto.getPassword() !=null && !dto.getPassword().isEmpty()){
            user.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        User updated=userRepository.save(user);
        return mapToResponse(updated);
    }


    @Override
    public void deleteUser(Long id) {
    User user=userRepository.findById(id).orElseThrow(()->new UserNotFoundException("user not found"));
    userRepository.delete(user);
    }
}
