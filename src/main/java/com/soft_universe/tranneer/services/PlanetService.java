package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.PlanetDTO;
import com.soft_universe.tranneer.entities.Planet;

import java.util.List;

public interface PlanetService {
    PlanetDTO savePlanet(PlanetDTO dto);
    PlanetDTO getPlanetById(Long id);
    List<PlanetDTO> getAllPlanets();
    PlanetDTO updatePlanet(Long id,PlanetDTO dto);
    void deletePlanet(Long id);
}
