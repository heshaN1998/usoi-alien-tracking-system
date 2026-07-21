package com.soft_universe.tranneer.ai.rag;

import org.springframework.ai.document.Document;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.lang.annotation.Documented;
import java.util.List;

@Service
public class KnowledgeRetriever {
    private final VectorStore vectorStore;

    public KnowledgeRetriever(VectorStore vectorStore) {
        this.vectorStore = vectorStore;
    }

    public List<Document> search(String question) {
        return vectorStore.similaritySearch(question);
    }
}
