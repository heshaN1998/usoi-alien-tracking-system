package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Service
public class UniversalAIDataService {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;

    public UniversalAIDataService(AlienRepository alienRepository,PlanetRepository planetRepository){
        this.alienRepository=alienRepository;
        this.planetRepository=planetRepository;
    }

    public String collectiotUniverseData(){
        long totalAliens=alienRepository.count();
        long totalPlanet=planetRepository.count();
        long powerfulAliens=alienRepository.findAll().stream().filter(a->a.isHasPowers()).count();
        long warAliens=alienRepository.findAll().stream().filter(a->a.isPlanningWar()).count();
        long warPlanets=planetRepository.findAll().stream().filter(p->p.isHasWar()).count();

    return """
            Total Aliens:
            %d
            
            Total Planets:
            %d
            
           
            Powerful Aliens:
            %d
            
            
            Aliens Planning War:
            %d
            
            
            Planets With War:
            %d
            """
            .formatted(totalAliens,totalPlanet,powerfulAliens,warAliens,warPlanets);
    }
}
