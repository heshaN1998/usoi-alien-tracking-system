package com.soft_universe.tranneer.ai.agents.researchAgent;

import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;
import tools.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.stream.Collectors;

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


    private ResearchDTO analyze(String data) {
        try {
            String response = chatClient.prompt()
                    .user(promptBuilder.build(data))
                    .call()
                    .content();

            return objectMapper.readValue(response, ResearchDTO.class);
        } catch (Exception e) {
            throw new RuntimeException("Research analysis failed", e);

        }
    }

    @Override
    public ResearchDTO investigateUniverse() {
        List<Document> docs = knowledgeRetriever.search("Universe research");
        String context = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        return analyze(context);
    }


    @Override
    public ResearchDTO investigatePlanet(Long planetId) {
        Planet planet = planetRepository.findById(planetId).orElseThrow(() -> new RuntimeException("Planet not found"));
        List<Document> docs = knowledgeRetriever.search("Planet " + planet.getPlanetId());
        String rag = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        String context = """
                Planet:
                %s
                
                Current Data:
                
                %s
                
                Historical Knowledge:
                
                %s
                """
                .formatted(
                        planet.getPlanetId(), planet, rag);

        return analyze(context);
    }

    @Override
    public ResearchDTO investigateAlien(Long alienId) {
        Alien alien = alienRepository.findById(alienId).orElseThrow(() -> new RuntimeException("Alien not found"));
        List<Document> docs = knowledgeRetriever.search("Alien " + alien.getId());
        String rag = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        String context = """
                Alien:
                
                %s
                
                Historical Knowledge:
                
                %s
                """
                .formatted(alien, rag);

        return analyze(context);
    }
}
