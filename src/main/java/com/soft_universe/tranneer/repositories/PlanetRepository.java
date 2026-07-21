package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Planet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanetRepository extends JpaRepository<Planet,Long> {
    long countByHasWarTrue();
    long countByHasWarFalse();

    Optional<Planet> findTopByOrderByAvgIQDesc();
    List<Planet> findByHasWarTrue();
}
