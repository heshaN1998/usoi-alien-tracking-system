package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("personal")
@Component
public class PlanetTools {
    private final PlanetRepository repository;

    public PlanetTools(PlanetRepository repository) {
        this.repository = repository;
    }

    @Tool(name = "planetWithHighestIQ",description = "Returns the planet with the highest average IQ")
    public String planetWithHighestIQ() {
        return repository
                .findTopByOrderByAvgIQDesc()
                .map(Planet::toString)
                .orElse("No planet found.");
    }
}
