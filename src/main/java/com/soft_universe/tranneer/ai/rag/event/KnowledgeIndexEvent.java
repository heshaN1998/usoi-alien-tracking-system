package com.soft_universe.tranneer.ai.rag.event;

import lombok.Getter;

@Getter
public class KnowledgeIndexEvent {
    private final String type;
    private final Long id;
    private final IndexOperation operation;
    public KnowledgeIndexEvent(String type,Long id,IndexOperation operation){
        this.type=type;
        this.id=id;
        this.operation=operation;
    }
}
