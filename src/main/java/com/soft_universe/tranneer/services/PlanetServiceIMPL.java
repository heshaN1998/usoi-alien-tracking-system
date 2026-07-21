package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.ai.rag.event.IndexOperation;
import com.soft_universe.tranneer.ai.rag.event.KnowledgeEventPublisher;
import com.soft_universe.tranneer.dtos.PlanetDTO;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.exceptions.PlanetNotFoundException;
import com.soft_universe.tranneer.mapper.PlanetMapper;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetServiceIMPL implements PlanetService{
    private final PlanetRepository planetRepository;
    private final KnowledgeEventPublisher knowledgeEventPublisher;

    public PlanetServiceIMPL(PlanetRepository planetRepository,KnowledgeEventPublisher knowledgeEventPublisher){
        this.planetRepository=planetRepository;
        this.knowledgeEventPublisher=knowledgeEventPublisher;
    }


    @Override
    public PlanetDTO savePlanet(PlanetDTO dto) {
        Planet planet= PlanetMapper.dtoToEntity(dto);
        Planet savedPlanet=planetRepository.save(planet);
        knowledgeEventPublisher.publish("PLANET",savedPlanet.getPlanetId(), IndexOperation.CREATE);
        return PlanetMapper.entityToDto(savedPlanet);
    }

    @Override
    public PlanetDTO getPlanetById(Long id) {
        Planet planet=planetRepository.findById(id).orElseThrow(()->new PlanetNotFoundException("Planet Not Found"));
        return PlanetMapper.entityToDto(planet);
    }

    @Override
    public List<PlanetDTO> getAllPlanets() {
        return planetRepository.findAll().stream().map(PlanetMapper::entityToDto).toList();
    }

    @Override
    public PlanetDTO updatePlanet(Long id, PlanetDTO dto) {
        Planet exitingPlanet = planetRepository.findById(id).orElseThrow(()->new PlanetNotFoundException("Planet not found"));

        exitingPlanet.setGalaxy(dto.getGalaxy());
        exitingPlanet.setPlanetType(dto.getPlanetType());
        exitingPlanet.setTimeFrame(dto.getTimeFrame());
        exitingPlanet.setAvgIQ(dto.getAvgIQ());
        exitingPlanet.setRelativeGravity(dto.getRelativeGravity());
        exitingPlanet.setKnowledgeLevel(dto.getKnowledgeLevel());
        exitingPlanet.setAlienCount(dto.getAlienCount());
        exitingPlanet.setHasWar(dto.isHasWar());

        Planet updatedPlanet=planetRepository.save(exitingPlanet);
        knowledgeEventPublisher.publish("PLANET",updatedPlanet.getPlanetId(),IndexOperation.UPDATE);
        return PlanetMapper.entityToDto(updatedPlanet);
    }

    @Override
    public void deletePlanet(Long id) {
    Planet planet=planetRepository.findById(id).orElseThrow(()->new PlanetNotFoundException("Planet not found"));
    planetRepository.delete(planet);
    knowledgeEventPublisher.publish("PLANET",id,IndexOperation.DELETE);
        System.out.println("Deleted success");
    }
}
