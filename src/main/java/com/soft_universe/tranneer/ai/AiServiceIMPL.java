package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AiServiceIMPL implements AiService {
    private final ChatClient chatClient;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final UserRepository userRepository;

    public AiServiceIMPL(ChatClient.Builder builder, AlienRepository alienRepository, PlanetRepository planetRepository, UserRepository userRepository) {
        this.chatClient = builder.build();
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
        this.userRepository = userRepository;
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
}