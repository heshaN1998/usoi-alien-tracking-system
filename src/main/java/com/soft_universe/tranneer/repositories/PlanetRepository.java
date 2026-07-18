package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {
    long countByHasWarTrue();
    long countByHasWarFalse();

}
