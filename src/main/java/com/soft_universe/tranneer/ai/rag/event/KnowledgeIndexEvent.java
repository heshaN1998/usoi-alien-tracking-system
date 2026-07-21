package com.soft_universe.tranneer.ai.rag.event;

import lombok.Getter;

@Getter
public class KnowledgeIndexEvent {
    private final String type;
    private final Long id;
    public KnowledgeIndexEvent(String type,Long id){
        this.type=type;
        this.id=id;
    }
}
