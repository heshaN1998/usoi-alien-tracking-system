package com.soft_universe.tranneer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LoginResponseDTO {
    private  String accessToken;
    private String role;
}
