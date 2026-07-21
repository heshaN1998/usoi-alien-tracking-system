package com.soft_universe.tranneer.ai.rag;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.repositories.AlienRepository;
import org.springframework.stereotype.Service;

@Service
public class AlienKnowledgeService {
    private final AlienRepository repository;
    private final KnowledgeIndexer indexer;

    public AlienKnowledgeService(AlienRepository repository,KnowledgeIndexer indexer){
        this.repository=repository;
        this.indexer=indexer;

    }

    public void indexAlien(Long id){
        Alien alien = repository.findById(id).orElseThrow();
        String content =
                """
                Alien Id:
                %s
                
                IQ:
                %s
                
                Planet:
                %s
                
                Power:
                %s
                
                Planning War:
                %s
                """
                        .formatted(
                                alien.getIq(),
                                alien.getIq(),
                                alien.getPlanet().getPlanetId(),
                                alien.isHasPowers(),
                                alien.isPlanningWar()
                        );

        indexer.addDocument(content,"ALIEN",alien.getId());

    }
}
