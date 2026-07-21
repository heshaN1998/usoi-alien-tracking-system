package com.soft_universe.tranneer.ai.rag.event;

import com.soft_universe.tranneer.ai.rag.AlienKnowledgeService;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeIndexListener {
    private final AlienKnowledgeService alienKnowledgeService;

    public KnowledgeIndexListener(AlienKnowledgeService alienKnowledgeService) {
        this.alienKnowledgeService = alienKnowledgeService;

    }

    @Async
    @EventListener
    public void handle(KnowledgeIndexEvent event) {
        if (event.getType().equals("ALIEN")) {
            alienKnowledgeService.indexAlien(event.getId());
        }

    }
}
