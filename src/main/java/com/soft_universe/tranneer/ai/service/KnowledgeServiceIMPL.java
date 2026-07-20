package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class KnowledgeServiceIMPL {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;

    public KnowledgeServiceIMPL (AlienRepository alienRepository,PlanetRepository planetRepository){
        this.alienRepository=alienRepository;
        this.planetRepository=planetRepository;
    }
}
