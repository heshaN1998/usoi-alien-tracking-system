package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.enums.PhysicalStrength;
import com.soft_universe.tranneer.repositories.AlienRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class AlienTools {
    private final AlienRepository alienRepository;

    public AlienTools(AlienRepository alienRepository) {
        this.alienRepository = alienRepository;
    }

    @Tool(name = "getStrongestAlien", description = "Returns the strongest alien in the database")
    public String getStrongestAlien() {
        return alienRepository.findFirstByPhysicalStrength(PhysicalStrength.STRONGEST)
                .map(Alien::toString)
                .orElse("No strongest alien found.");
    }
}
