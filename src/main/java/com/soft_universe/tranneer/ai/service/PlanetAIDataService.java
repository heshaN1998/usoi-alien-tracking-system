package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetAIDataService {
    private final PlanetRepository planetRepository;

    public PlanetAIDataService(PlanetRepository planetRepository) {
        this.planetRepository = planetRepository;
    }

    public Planet getPlanet(Long id) {
        return planetRepository.findById(id).orElseThrow(() -> new RuntimeException("Planet not found"));
    }
}