package com.soft_universe.tranneer.mapper;

import com.soft_universe.tranneer.dtos.PlanetDTO;
import com.soft_universe.tranneer.entities.Planet;

public class PlanetMapper {
    public static Planet dtoToEntity(PlanetDTO dto) {
        Planet planet = new Planet();

        planet.setGalaxy(dto.getGalaxy());
        planet.setPlanetType(dto.getPlanetType());
        planet.setTimeFrame(dto.getTimeFrame());
        planet.setAvgIQ(dto.getAvgIQ());
        planet.setRelativeGravity(dto.getRelativeGravity());
        planet.setKnowledgeLevel(dto.getKnowledgeLevel());
        planet.setAlienCount(dto.getAlienCount());
        planet.setHasWar(dto.isHasWar());
        return planet;
    }
    public static PlanetDTO entityToDto(Planet planet){
        PlanetDTO dto=new PlanetDTO();

        dto.setPlanetId(planet.getPlanetId());
        dto.setGalaxy(planet.getGalaxy());
        dto.setPlanetType(planet.getPlanetType());
        dto.setTimeFrame(planet.getTimeFrame());
        dto.setAvgIQ(planet.getAvgIQ());
        dto.setRelativeGravity(planet.getRelativeGravity());
        dto.setKnowledgeLevel(planet.getKnowledgeLevel());
        dto.setAlienCount(planet.getAlienCount());
        dto.setHasWar(planet.isHasWar());
        return dto;
    }
}
