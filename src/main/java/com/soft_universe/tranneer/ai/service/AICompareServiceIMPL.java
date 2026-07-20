package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.*;
import com.soft_universe.tranneer.ai.prompt.ComparePromptBuilder;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AICompareServiceIMPL implements AICompareService {
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final ComparePromptBuilder promptBuilder;
    private final ChatClient chatClient;

    public AICompareServiceIMPL(AlienRepository alienRepository, PlanetRepository planetRepository, ComparePromptBuilder promptBuilder, ChatClient.Builder chatClientBuilder) {
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
        this.promptBuilder = promptBuilder;
        this.chatClient = chatClientBuilder.build();

    }

    @Override
    public CompareResponseDTO compare(CompareRequestDTO request) {
        String prompt;
        if (request.getType() == ComparisonType.ALIEN) {
            Alien first = alienRepository.findById(request.getFirstId()).orElseThrow();
            Alien second = alienRepository.findById(request.getSecondId()).orElseThrow();

            prompt = promptBuilder.buildAlienPrompt(first, second);

        } else {
            Planet first = planetRepository.findById(request.getFirstId()).orElseThrow();
            Planet second = planetRepository.findById(request.getSecondId()).orElseThrow();
            prompt = promptBuilder.buildPlanetPrompt(first, second);
        }

        String answer = chatClient.prompt().user(prompt).call().content();
        return new CompareResponseDTO(answer);

    }
}