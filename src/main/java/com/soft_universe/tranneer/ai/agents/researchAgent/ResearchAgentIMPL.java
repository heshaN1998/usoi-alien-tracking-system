package com.soft_universe.tranneer.ai.agents.researchAgent;

import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResearchAgentIMPL implements ResearchAgent {
    private final ChatClient chatClient;
    private final ResearchPromptBuilder promptBuilder;
    private final KnowledgeRetriever knowledgeRetriever;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;


    public ResearchAgentIMPL(ChatClient chatClient, ResearchPromptBuilder promptBuilder, KnowledgeRetriever knowledgeRetriever, AlienRepository alienRepository, PlanetRepository planetRepository) {
        this.chatClient = chatClient;
        this.promptBuilder = promptBuilder;
        this.knowledgeRetriever = knowledgeRetriever;
        this.alienRepository = alienRepository;
        this.planetRepository = planetRepository;


    }


    private ResearchDTO analyze(String data) {
        try {
            return chatClient.prompt()
                    .user(promptBuilder.build(data))
                    .call()
                    .entity(ResearchDTO.class);

        } catch (Exception e) {
            throw new RuntimeException("Research analysis failed", e);

        }
    }

    @Override
    public ResearchDTO investigateUniverse() {
        List<Document> docs = knowledgeRetriever.search("Universe history wars civilizations galaxies diplomacy");
        String context = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        return analyze(context);
    }


    @Override
    public ResearchDTO investigatePlanet(Long planetId) {
        Planet planet = planetRepository.findById(planetId).orElseThrow(() -> new RuntimeException("Planet not found"));
        List<Document> docs = knowledgeRetriever.search("Planet " + planet.getPlanetId());
        String knowledge = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        String context = """
                Planet Information
                
                Planet ID: %d
                Galaxy: %s
                Average IQ: %.2f
                Alien Count: %d
                Has War: %s
                
                Historical Knowledge:
                
                %s
                """
                .formatted(
                        planet.getPlanetId(),
                        planet.getGalaxy(),
                        planet.getAvgIQ(),
                        planet.getAlienCount(),
                        planet.isHasWar(),
                        knowledge);

        return analyze(context);
    }

    @Override
    public ResearchDTO investigateAlien(Long alienId) {
        Alien alien = alienRepository.findById(alienId).orElseThrow(() -> new RuntimeException("Alien not found"));
        List<Document> docs = knowledgeRetriever.search("Alien " + alien.getId());
        String knowledge = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
        String context = """
                Alien Research
                
                Alien ID: %d
                Intelligence IQ: %d
                Has Special Powers: %s
                Planning War: %s
                Home Planet: %d
                 Historical Knowledge: %s
                """
                .formatted(alien.getId(),
                        alien.getIq(),
                        alien.isHasPowers(),
                        alien.isPlanningWar(),
                        alien.getPlanet().getPlanetId(),
                        knowledge);

        return analyze(context);
    }
}
