package com.soft_universe.tranneer.ai.agents.securityAgent;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class SecurityAgentIMPL implements SecurityAgent {
    private final ChatClient chatClient;
    private final SecurityPromptBuilder promptBuilder;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final ObjectMapper objectMapper;

    public SecurityAgentIMPL(ChatClient chatClient, SecurityPromptBuilder promptBuilder, AlienRepository alienRepository, PlanetRepository planetRepository, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.promptBuilder = promptBuilder;
        this.planetRepository = planetRepository;
        this.alienRepository = alienRepository;
        this.objectMapper = objectMapper;
    }

    private SecurityAnalysisDTO analyze(String data) {
        String response = chatClient.prompt().user(promptBuilder.build(data)).call().content();

        try {
            return objectMapper.readValue(response, SecurityAnalysisDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("AI response parsing failed", e);
        }

    }

    @Override
    public SecurityAnalysisDTO analyzeUniverse() {
        String data = """
                Aliens Planning War:
                
                %s
                
                Planets At War:
                
                %s
                """
                .formatted(alienRepository.findByPlanningWarTrue(), planetRepository.findByHasWarTrue());
        return analyze(data);

    }

    @Override
    public SecurityAnalysisDTO analyzeAlien(Long alienId) {
        Alien alien = alienRepository.findById(alienId).orElseThrow(() -> new RuntimeException("Alien not found"));
        String data = """
                Alien Security Analysis
                
                Id:
                %s
                
                IQ:
                %s
                
                Powers:
                %s
                
                Planning War:
                %s
                
                Planet :
                %s
                """
                .formatted(
                        alien.getId(),
                        alien.getIq(),
                        alien.isHasPowers(),
                        alien.isPlanningWar(),
                        alien.getPlanet().getPlanetId()
                );
        return analyze(data);
    }


    @Override
    public SecurityAnalysisDTO analyzePlanet(Long planetId) {
        Planet planet = planetRepository.findById(planetId).orElseThrow(() -> new RuntimeException("Planet not found"));
        String data = """
                Planet Security Analysis
                
                Name:
                %s
                
                Galaxy:
                %s
                
                Average IQ:
                %s
                
                War Status:
                %s
                
                Alien Population:
                %s
                """
                .formatted(
                        planet.getPlanetId(),
                        planet.getGalaxy(),
                        planet.getAvgIQ(),
                        planet.isHasWar(),
                        planet.getAlienCount()
                );
        return analyze(data);
    }
}


