package com.soft_universe.tranneer.ai.rag.event;

import com.soft_universe.tranneer.ai.rag.AlienKnowledgeService;
import com.soft_universe.tranneer.ai.rag.KnowledgeIndexer;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeIndexListener {
    private final AlienKnowledgeService alienKnowledgeService;
    private final PlanetKnowledgeService planetKnowledgeService;
    private KnowledgeIndexer knowledgeIndexer;

    public KnowledgeIndexListener(AlienKnowledgeService alienKnowledgeService,PlanetKnowledgeService planetKnowledgeService,KnowledgeIndexer knowledgeIndexer) {
        this.alienKnowledgeService = alienKnowledgeService;
        this.planetKnowledgeService=planetKnowledgeService;
        this.knowledgeIndexer=knowledgeIndexer;

    }

    @Async
    @EventListener
        public void handle(KnowledgeIndexEvent event) {
        if(event.getOperation()==IndexOperation.DELETE){
            knowledgeIndexer.deleteDocument(event.getType(),event.getId());
        }
        switch (event.getType()){
            case "ALIEN" -> alienKnowledgeService.indexAlien(event.getId());
            case "PLANET" -> planetKnowledgeService.indexPlanet(event.getId());
        }

    }
//    public void handle(KnowledgeIndexEvent event) {
////        if (event.getType().equals("ALIEN")) {
////            alienKnowledgeService.indexAlien(event.getId());
////        }
//
//    }
}
