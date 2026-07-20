package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.RecommendationDTO;
import com.soft_universe.tranneer.ai.dtos.RecommendationType;
import com.soft_universe.tranneer.ai.prompt.RecommendationPromptBuilder;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AIRecommendationServiceIMPL implements AIRecommendationService{
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final ChatClient chatClient;
    private final RecommendationPromptBuilder promptBuilder;

    public AIRecommendationServiceIMPL(AlienRepository alienRepository,PlanetRepository planetRepository,ChatClient chatClient,RecommendationPromptBuilder promptBuilder){
        this.alienRepository=alienRepository;
        this.planetRepository=planetRepository;
        this.chatClient=chatClient;
        this.promptBuilder=promptBuilder;
    }
    @Override
    public List<RecommendationDTO> generateRecommendations() {
        String universeData = """
                Total Aliens: %d
                Total Planets: %d
                Aliens Planning War: %d
                Planets With War: %d
                """
                .formatted(
                        alienRepository.count(),
                        planetRepository.count(),
                        alienRepository.countByPlanningWarTrue(),
                        planetRepository.countByHasWarTrue()
                );

        String prompt = promptBuilder.buildPrompt(universeData);
        String response = chatClient.prompt().user(prompt).call().content();

        return List.of(new RecommendationDTO(RecommendationType.GENERAL,"Universe Recommendations",response,"HIGH"));
    }
}
