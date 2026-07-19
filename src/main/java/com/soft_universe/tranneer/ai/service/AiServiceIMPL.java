package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.PlanetAIInsightDTO;
import com.soft_universe.tranneer.ai.prompt.AIPromptBuilder;
import com.soft_universe.tranneer.ai.dtos.AIResponseDTO;
import com.soft_universe.tranneer.ai.prompt.PlanetAIPromptBuilder;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;


@Service
public class AiServiceIMPL implements AiService {
    private final ChatClient chatClient;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final UserRepository userRepository;
    private final PlanetAIDataService planetAIDataService;

    public AiServiceIMPL(ChatClient.Builder builder, AlienRepository alienRepository, PlanetRepository planetRepository, UserRepository userRepository,PlanetAIDataService planetAIDataService) {
        this.chatClient = builder.build();
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
        this.userRepository = userRepository;
        this.planetAIDataService=planetAIDataService;
    }

    @Override
    public AIResponseDTO generateDashbordInsights() {
        long totalAliens = alienRepository.count();
        long totalPlanet = planetRepository.count();
        long totalUser = userRepository.count();
        Double avgIq = alienRepository.findAverageIq();

        if (avgIq == null) {
            avgIq = 0.0;
        }
        String prompt = AIPromptBuilder.dashboardInsightPrompt(totalAliens, totalPlanet, totalUser, avgIq);
        return chatClient.prompt(prompt).call().entity(AIResponseDTO.class);
    }

    @Override
    public PlanetAIInsightDTO analyzePlanet(Long planetId) {
        Planet planet=planetAIDataService.getPlanet(planetId);
        long alienCount=planet.getAliens().size();
        long powerfulAliens=planet.getAliens().stream().filter(a->a.isHasPowers()).count();
        long warAliens=planet.getAliens().stream().filter(a->a.isPlanningWar()).count();

        String data = """

Planet Galaxy:
%s

Planet Type:
%s

Knowledge Level:
%d

Average IQ:
%.2f

Gravity:
%s

Has War:
%s

Alien Count:
%d

Powerful Aliens:
%d

Aliens Planning War:
%d

"""
                .formatted(planet.getGalaxy(),
                        planet.getPlanetType(),
                        planet.getKnowledgeLevel(),
                        planet.getAvgIQ(), planet.getRelativeGravity(),
                        planet.isHasWar(),
                        alienCount,
                        powerfulAliens,
                        warAliens
                );

        String prompt =PlanetAIPromptBuilder.build(data);
        return chatClient.prompt(prompt).call().entity(PlanetAIInsightDTO.class);

    }
}