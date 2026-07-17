package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.LoginRequestDTO;
import com.soft_universe.tranneer.dtos.LoginResponseDTO;

public interface AuthService {
    LoginResponseDTO login(LoginRequestDTO requestDTO);
}
