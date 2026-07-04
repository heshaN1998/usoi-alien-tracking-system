package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Alien;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlienRepository extends JpaRepository<Alien,Long> {
}
