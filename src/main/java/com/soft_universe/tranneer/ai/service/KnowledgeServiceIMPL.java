package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeServiceIMPL implements KnowledgeService {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;

    public KnowledgeServiceIMPL(AlienRepository alienRepository, PlanetRepository planetRepository) {
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
    }

    @Override
    public String getUniverseKnowledge() {
        StringBuilder knowledge = new StringBuilder();
        knowledge.append("PLANETS INFORMATION\n");

        planetRepository.findAll().forEach(planet -> {
            knowledge.append(
                    """
                              Planet ID: %d
                              Galaxy: %s
                              Type: %s
                              Gravity: %s
                              War Status: %s
                            
                            """
                            .formatted(
                                    planet.getPlanetId(),
                                    planet.getGalaxy(),
                                    planet.getPlanetType(),
                                    planet.getRelativeGravity(),
                                    planet.isHasWar())

            );
        });
        knowledge.append("ALIENS INFORMATION\n");
        alienRepository.findAll().forEach(alien -> {
            knowledge.append(
                    """
                                   Alien ID: %d
                                   IQ: %d
                                   Type: %s
                                   Language: %s
                                   Has Powers: %s
                                   Planning War: %s
                            """
                            .formatted(
                                    alien.getId(),
                                    alien.getIq(),
                                    alien.getAlienType(),
                                    alien.getLanguage(),
                                    alien.isHasPowers(),
                                    alien.isPlanningWar()
                            )
            );
        });
        return knowledge.toString();
    }
}
