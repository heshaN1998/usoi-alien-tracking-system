package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.checkerframework.checker.units.qual.N;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class SecurityTool {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;

    public SecurityTool(AlienRepository alienRepository, PlanetRepository planetRepository) {
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
    }

    @Tool(name = "fondDangerousAliens", description = "find aliens with high level threat")
    public String dangerousAliens() {
        return alienRepository.findByPlanningWarTrue().toString();
    }

    @Tool(name = "PlanetsAtWar", description = "find planets currently in war")
    public String planetsAtWar() {
        return planetRepository.findByHasWarTrue().toString();
    }
}
