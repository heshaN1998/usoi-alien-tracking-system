package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.ChatResponseDTO;
import com.soft_universe.tranneer.ai.prompt.ChatPromptBuilder;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AIChatServiceIMPL implements AIChatService{
    private final ChatClient chatClient;
    private final KnowledgeService knowledgeService;

    public AIChatServiceIMPL(ChatClient chatClient,KnowledgeService knowledgeService){
        this.chatClient=chatClient;
        this.knowledgeService=knowledgeService;
    }

    @Override
    public ChatResponseDTO ask(String question) {
        String knowledge=knowledgeService.getUniverseKnowledge();
        String prompt= ChatPromptBuilder.build(knowledge,question);
        String answer=chatClient.prompt(prompt).call().content();

        return new ChatResponseDTO(answer);
    }
}
