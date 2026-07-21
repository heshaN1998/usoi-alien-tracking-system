package com.soft_universe.tranneer.ai.rag;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class KnowledgeIndexer {
    private final VectorStore vectorStore;

    public KnowledgeIndexer(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public void addDocument(String text, String type, Long id) {
        Document document = new Document(text, Map.of("type", type, "id", id));
        vectorStore.add(List.of(document));
    }
}