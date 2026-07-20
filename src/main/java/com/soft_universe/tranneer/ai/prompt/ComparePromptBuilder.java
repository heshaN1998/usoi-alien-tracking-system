package com.soft_universe.tranneer.ai.prompt;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import org.springframework.stereotype.Component;

@Component
public class ComparePromptBuilder {
    public String buildAlienPrompt(Alien first, Alien second) {
        return """
                Compare the following two aliens.
                
                Alien 1
                --------
                IQ: %d
                Type: %s
                Planet: %s
                Age: %d
                IQ Level: %s
                Physical Strength: %s
                Has Powers: %s
                Planning War: %s
                
                Alien 2
                --------
                IQ: %d
                Type: %s
                Planet: %s
                Age: %d
                IQ Level: %s
                Physical Strength: %s
                Has Powers: %s
                Planning War: %s
                
                Give:
                
                1. Strength comparison
                2. Intelligence comparison
                3. Threat comparison
                4. Overall winner
                """
                .formatted(

                        first.getIq(),
                        first.getAlienType(),
                        first.getPlanet().getGalaxy(),
                        first.getAge(),
                        first.getIqLevel(),
                        first.getPhysicalStrength(),
                        first.isHasPowers(),
                        first.isPlanningWar(),

                        second.getIq(),
                        second.getAlienType(),
                        second.getPlanet().getGalaxy(),
                        second.getAge(),
                        second.getIqLevel(),
                        second.getPhysicalStrength(),
                        second.isHasPowers(),
                        second.isPlanningWar()
                );
    }

    public String buildPlanetPrompt(Planet first, Planet second) {
        return """
                Compare these planets.
                
                Planet 1
                --------
                Galaxy: %s
                Type: %s
                Average IQ: %.2f
                Gravity: %s
                Knowledge Level: %d
                Alien Count: %d
                War: %s
                
                Planet 2
                --------
                Galaxy: %s
                Type: %s
                Average IQ: %.2f
                Gravity: %s
                Knowledge Level: %d
                Alien Count: %d
                War: %s
                
                Explain:
                
                - Which civilization is stronger?
                - Which planet is safer?
                - Which planet has better development?
                - Final recommendation.
                """
                .formatted(
                        first.getGalaxy(),
                        first.getPlanetType(),
                        first.getAvgIQ(),
                        first.getRelativeGravity(),
                        first.getKnowledgeLevel(),
                        first.getAlienCount(),
                        first.isHasWar(),

                        second.getGalaxy(),
                        second.getPlanetType(),
                        second.getAvgIQ(),
                        second.getRelativeGravity(),
                        second.getKnowledgeLevel(),
                        second.getAlienCount(),
                        second.isHasWar()
                );
    }
}