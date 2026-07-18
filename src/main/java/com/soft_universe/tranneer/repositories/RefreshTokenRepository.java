package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.RefreshToken;
import com.soft_universe.tranneer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken,Long> {
Optional<RefreshToken> findByToken(String token);
void deleteByUser(User user);

}
