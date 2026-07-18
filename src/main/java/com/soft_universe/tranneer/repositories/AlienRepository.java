package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Alien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepository extends JpaRepository<Alien,Long> {
}
