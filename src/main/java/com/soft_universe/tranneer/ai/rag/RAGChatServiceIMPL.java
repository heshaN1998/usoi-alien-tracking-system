package com.soft_universe.tranneer.ai.rag;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RAGChatServiceIMPL {
    private final ChatClient chatClient;
    private final KnowledgeRetriever retriever;

    public RAGChatServiceIMPL(ChatClient chatClient,KnowledgeRetriever retriever){
        this.chatClient=chatClient;
        this.retriever=retriever;
    }

    public String ask(String question) {
        List<Document> docs = retriever.search(question);
        String context = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));

        return chatClient.prompt().user("""
                Answer using this knowledge:
                
                %s
                
                Question:
                %s
                
                """
                .formatted(context, question)
        ).call().content();
    }
}
