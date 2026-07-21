package com.soft_universe.tranneer.ai.agents.predictAgent;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class PredictionAgentIMPL implements PredictionAgent {
    private final ChatClient chatClient;
    private final PredictPromptBuilder promptBuilder;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final ObjectMapper objectMapper;

    public PredictionAgentIMPL(ChatClient chatClient, PredictPromptBuilder promptBuilder, AlienRepository alienRepository, PlanetRepository planetRepository, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
        this.promptBuilder = promptBuilder;
        this.objectMapper = objectMapper;
    }

    private PredictionDTO predict(String data, String predictionType) {
        try {
            String response = chatClient.prompt()
                    .user(promptBuilder.build(data, predictionType))
                    .call()
                    .content();
            return objectMapper.readValue(response, PredictionDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Prediction failed", e);
        }
    }


    @Override
    public PredictionDTO predictWar() {
        String data = """
                Universe War Statistics
                
                Aliens Planning War: %s
                Planets At War: %s
                Total Aliens: %s
                Total Planets: %s
                """
                .formatted(
                        alienRepository.countByPlanningWarTrue(),
                        planetRepository.countByHasWarTrue(),
                        alienRepository.count(),
                        planetRepository.count()
                );
        return predict(data, "UNIVERSE WAR");
    }

    @Override
    public PredictionDTO predictWar(Long planetId) {
        Planet planet = planetRepository.findById(planetId).orElseThrow(() -> new RuntimeException("Planet not found"));
        String data = """
                Planet War Prediction
                
                Planet: %s
                Galaxy: %s
                Has War: %s
                Average IQ: %s
                Alien Count: %s
                """
                .formatted(
                        planet.getPlanetId(),
                        planet.getGalaxy(),
                        planet.isHasWar(),
                        planet.getAvgIQ(),
                        planet.getAlienCount()
                );
        return predict(data, "PLANET WAR");
    }

    @Override
    public PredictionDTO predictAlienThreat(Long alienId) {
        Alien alien = alienRepository.findById(alienId).orElseThrow(() -> new RuntimeException("Alien not found"));
        String data = """
                Alien Threat Prediction
                
                Name: %s
                IQ: %s
                Powers: %s
                Planning War: %s
                Planet: %s
                """
                .formatted(
                        alien.getId(),
                        alien.getIq(),
                        alien.isHasPowers(),
                        alien.isPlanningWar(),
                        alien.getPlanet().getPlanetId()
                );
        return predict(data, "ALIEN THREAT");
    }
}
