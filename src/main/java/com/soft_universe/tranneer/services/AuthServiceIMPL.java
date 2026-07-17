package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.LoginRequestDTO;
import com.soft_universe.tranneer.dtos.LoginResponseDTO;
import com.soft_universe.tranneer.repositories.UserRepository;
import com.soft_universe.tranneer.security.JwtService;
import com.soft_universe.tranneer.entities.User;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceIMPL implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthServiceIMPL(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String token = jwtService.generateToken(userDetails);
        User user = userRepository.findUserName(request.getUserName()).orElseThrow();
        return new LoginResponseDTO(token, user.getRole().name()
        );
    }
}