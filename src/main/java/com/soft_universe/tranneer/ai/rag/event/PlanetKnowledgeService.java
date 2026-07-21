package com.soft_universe.tranneer.ai.rag.event;

import com.soft_universe.tranneer.ai.rag.KnowledgeIndexer;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import org.springframework.stereotype.Service;

@Service
public class PlanetKnowledgeService {
    private final PlanetRepository planetRepository;
    private final KnowledgeIndexer knowledgeIndexer;

    public PlanetKnowledgeService(PlanetRepository planetRepository, KnowledgeIndexer knowledgeIndexer) {
        this.planetRepository = planetRepository;
        this.knowledgeIndexer = knowledgeIndexer;
    }

    public void indexPlanet(Long id) {
        Planet planet = planetRepository.findById(id).orElseThrow();
        String content =
                """
                        Planet Information
                        
                        Name:
                        %s
                        
                        Galaxy:
                        %s
                        
                        Planet Type:
                        %s
                        
                        Average IQ:
                        %s
                        
                        Alien Population:
                        %s
                        
                        War Status:
                        %s
                        
                        Gravity:
                        %s
                        
                        """
                        .formatted(
                                planet.getPlanetId(),
                                planet.getGalaxy(),
                                planet.getPlanetType(),
                                planet.getAvgIQ(),
                                planet.getAlienCount(),
                                planet.isHasWar(),
                                planet.getRelativeGravity()
                        );
        knowledgeIndexer.addDocument(content, "PLANE", planet.getPlanetId());
    }
}
