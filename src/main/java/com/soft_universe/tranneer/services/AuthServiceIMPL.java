package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.LoginRequestDTO;
import com.soft_universe.tranneer.dtos.LoginResponseDTO;
import com.soft_universe.tranneer.dtos.RefreshTokenRequestDTO;
import com.soft_universe.tranneer.entities.RefreshToken;
import com.soft_universe.tranneer.repositories.RefreshTokenRepository;
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
    private final RefreshTokenService refreshTokenService;
    private final RefreshTokenRepository refreshTokenRepository;

    public AuthServiceIMPL(AuthenticationManager authenticationManager, UserRepository userRepository, JwtService jwtService, RefreshTokenService refreshTokenService, RefreshTokenRepository refreshTokenRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.refreshTokenService=refreshTokenService;
        this.refreshTokenRepository=refreshTokenRepository;
    }

    @Override
    public LoginResponseDTO login(LoginRequestDTO request) {

        Authentication authentication = authenticationManager.authenticate(
                 new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword()));

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String accessToken=jwtService.generateToken(userDetails);
        User user = userRepository.findUserName(request.getUserName()).orElseThrow();
        RefreshToken refreshToken=refreshTokenService.createToken(user);
        return new LoginResponseDTO(accessToken, refreshToken.getToken(),user.getRole().name());
    }

    @Override
    public LoginResponseDTO refreshToken(RefreshTokenRequestDTO request) {
        RefreshToken refreshToken =
                refreshTokenRepository
                        .findByToken(request.getRefreshToken())
                        .orElseThrow(() -> new RuntimeException("Invalid refresh token"));
        refreshTokenService.verifyExpiration(refreshToken);

        User user = refreshToken.getUser();
        UserDetails userDetails = org.springframework.security.core.userdetails.User
                        .builder()
                        .username(user.getUserName())
                        .password(user.getPassword())
                        .roles(user.getRole().name())
                        .build();

        String newAccessToken = jwtService.generateToken(userDetails);
        return new LoginResponseDTO(
                newAccessToken,
                refreshToken.getToken(),
                user.getRole().name()
        );
    }

    @Override
    public void logout(String refreshToken) {
        refreshTokenService.deleteToken(refreshToken);
    }
}