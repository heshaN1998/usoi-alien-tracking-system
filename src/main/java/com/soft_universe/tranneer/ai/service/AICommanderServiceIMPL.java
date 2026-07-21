package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;
import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AICommanderServiceIMPL implements AICommanderService{
    private final ChatClient chatClient;
    private final KnowledgeRetriever retriever;

    public AICommanderServiceIMPL(ChatClient chatClient,KnowledgeRetriever retriever){
        this.chatClient=chatClient;
        this.retriever=retriever;
    }


    @Override
    public CommanderResponseDTO execute(String command) {
        List<Document> docs=retriever.search(command);

        String context=docs.stream().map(Document::getText).collect(Collectors.joining());
        String answer=chatClient.prompt().user(command+"\n\n"+context).call().content();

        return new CommanderResponseDTO("ANALYSIS COMPLETE","EXICUTE",answer);
    }
}
