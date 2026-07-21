package com.soft_universe.tranneer.ai.rag.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class KnowledgeEventPublisher {
    private final ApplicationEventPublisher publisher;

    public KnowledgeEventPublisher(ApplicationEventPublisher publisher){
        this.publisher=publisher;
    }

    public void publish(String type,Long id){
        publisher.publishEvent(new KnowledgeIndexEvent(type,id));
    }

}
