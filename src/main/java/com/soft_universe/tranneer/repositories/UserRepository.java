package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Role;
import com.soft_universe.tranneer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findUserName(String userName);
    long countByRole(Role role);
}
