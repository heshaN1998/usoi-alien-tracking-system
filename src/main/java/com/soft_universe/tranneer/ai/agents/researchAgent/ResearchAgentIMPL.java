package com.soft_universe.tranneer.ai.agents.researchAgent;

import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

@Service
public class ResearchAgentIMPL implements ResearchAgent {
    private final ChatClient chatClient;
    private final ResearchPromptBuilder promptBuilder;
    private final KnowledgeRetriever knowledgeRetriever;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final ObjectMapper objectMapper;

    public ResearchAgentIMPL(ChatClient chatClient, ResearchPromptBuilder promptBuilder, KnowledgeRetriever knowledgeRetriever, AlienRepository alienRepository, PlanetRepository planetRepository, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.promptBuilder = promptBuilder;
        this.knowledgeRetriever = knowledgeRetriever;
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public ResearchDTO investigateUniverse() {
        return null;
    }

    @Override
    public ResearchDTO investigatePlanet(Long planetId) {
        return null;
    }

    @Override
    public ResearchDTO investigateAlien(Long alienId) {
        return null;
    }
}
