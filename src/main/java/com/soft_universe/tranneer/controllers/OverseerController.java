package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.dtos.UserRequestDTO;
import com.soft_universe.tranneer.dtos.UserResponseDTO;
import com.soft_universe.tranneer.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/overseer/users")
@CrossOrigin
@PreAuthorize("hasRole('OVERSEER')")
public class OverseerController {
    private final UserService userService;

    public OverseerController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        return userService.createUser(dto);
    }


    @GetMapping
    public List<UserResponseDTO> getUsers() {
        return userService.getAllUsers();
    }


    @GetMapping("/{id}")
    public UserResponseDTO getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }


    @PutMapping("/{id}")
    public UserResponseDTO updateUser(@PathVariable Long id, @RequestBody UserRequestDTO dto) {
        return userService.updateUser(id, dto);
    }


    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
