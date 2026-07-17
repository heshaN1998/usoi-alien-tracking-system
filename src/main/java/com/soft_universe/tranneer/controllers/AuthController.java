package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.dtos.LoginRequestDTO;
import com.soft_universe.tranneer.dtos.LoginResponseDTO;
import com.soft_universe.tranneer.services.AuthService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public LoginResponseDTO login(@RequestBody LoginRequestDTO request) {
        return authService.login(request);
    }

}