package com.soft_universe.tranneer.ai.tools;


import com.soft_universe.tranneer.repositories.*;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;


@Component
public class PredictionTools {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;

    public PredictionTools(AlienRepository alienRepository, PlanetRepository planetRepository) {
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;

    }


    @Tool(name = "warStatistics", description = "Returns current war related statistics")
    public String warStatistics() {
        return """
                
                Aliens Planning War:
                %s
                
                
                Planets With War:
                %s
                
                """
                .formatted(alienRepository.countByPlanningWarTrue(), planetRepository.countByHasWarTrue());
    }

    @Tool(name = "powerfulAliens", description = "Returns powerful aliens")
    public String powerfulAliens() {
        return alienRepository.findByHasPowersTrue().toString();

    }

    @Tool(name = "planetGrowthData", description = "Returns planet development information")
    public String planetGrowthData(Long id) {
        return planetRepository.findById(id).orElseThrow().toString();

    }
}