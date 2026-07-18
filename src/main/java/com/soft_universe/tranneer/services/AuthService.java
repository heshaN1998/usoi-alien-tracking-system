package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.LoginRequestDTO;
import com.soft_universe.tranneer.dtos.LoginResponseDTO;
import com.soft_universe.tranneer.dtos.RefreshTokenRequestDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO requestDTO);
    LoginResponseDTO refreshToken(RefreshTokenRequestDTO request);
    void logout(String refreshToken);
}
