package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Role;
import com.soft_universe.tranneer.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUserName(String userName);
    long countByRole(Role role);
}
