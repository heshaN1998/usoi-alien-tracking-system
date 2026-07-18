package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.entities.RefreshToken;
import com.soft_universe.tranneer.entities.User;
import com.soft_universe.tranneer.repositories.RefreshTokenRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {
private final RefreshTokenRepository tokenRepository;

    public RefreshToken createToken(User user){
        RefreshToken token = new RefreshToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate(LocalDateTime.now().plusDays(7));

        return tokenRepository.save(token);
    }
    public RefreshToken verifyExpiration(RefreshToken token){
        if(token.getExpiryDate().isBefore(LocalDateTime.now())){
            tokenRepository.delete(token);
            throw new RuntimeException("Refresh token expired");
        }
        return token;
    }


    public void deleteToken(String token){
        RefreshToken refreshToken = tokenRepository.findByToken(token).orElseThrow(() -> new RuntimeException("Refresh token not found"));
        tokenRepository.delete(refreshToken);
    }
}
