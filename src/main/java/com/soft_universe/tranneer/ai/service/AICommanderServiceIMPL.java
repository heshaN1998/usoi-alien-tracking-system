package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.agents.predictAgent.PredictionAgent;
import com.soft_universe.tranneer.ai.agents.researchAgent.ResearchAgent;
import com.soft_universe.tranneer.ai.agents.securityAgent.SecurityAgent;
import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;
import com.soft_universe.tranneer.ai.memory.PersistentMemoryService;
import com.soft_universe.tranneer.ai.prompt.CommanderPromptBuilder;
import com.soft_universe.tranneer.ai.rag.CommanderKnowledgeService;
import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.ai.tools.PredictTools;
import com.soft_universe.tranneer.ai.tools.ReasearchTools;
import com.soft_universe.tranneer.ai.tools.SecureTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.messages.AssistantMessage;
import org.springframework.ai.chat.messages.Message;

import java.util.List;


@Service
public class AICommanderServiceIMPL implements AICommanderService {
    private final ChatClient chatClient;
    private final KnowledgeRetriever retriever;
    private final CommanderPromptBuilder promptBuilder;

    private final SecureTools secureTools;
    private final ReasearchTools reasearchTools;
    private final PredictTools predictTools;
    private final CommanderKnowledgeService knowledgeService;
    private final ChatMemory chatMemory;
    private final PersistentMemoryService memoryService;

    public AICommanderServiceIMPL(ChatClient chatClient,
                                  KnowledgeRetriever retriever,
                                  CommanderPromptBuilder promptBuilder,
                                  SecureTools secureTools,
                                  ReasearchTools reasearchTools,
                                  PredictTools predictTools,
                                  CommanderKnowledgeService knowledgeService,
                                  ChatMemory chatMemory,
                                  PersistentMemoryService memoryService
    ) {
        this.chatClient = chatClient;
        this.retriever = retriever;
        this.promptBuilder = promptBuilder;
        this.secureTools = secureTools;
        this.predictTools = predictTools;
        this.reasearchTools = reasearchTools;
        this.knowledgeService = knowledgeService;
        this.chatMemory = chatMemory;
        this.memoryService = memoryService;

    }


    @Override
    public CommanderResponseDTO execute(String userId, String command) {
        String history = memoryService.getHistory(userId);
        String knowledge = knowledgeService.retrieve(command);
        memoryService.save(userId, "USER", command);

        String response = chatClient
                .prompt()
                .user("""
                        
                        Previous Conversation:
                        
                        %s
                        
                        
                        Knowledge:
                        
                        %s
                        
                        
                        Request:
                        
                        %s
                        
                        """.formatted(history, knowledge, command))
                .tools(secureTools, reasearchTools, predictTools)
                .call()
                .content();
        memoryService.save(
                userId,
                "AI",
                response
        );

        return new CommanderResponseDTO("COMMANDER DECISION", "RAG ANALYSIS WITH TOOLS WITH MEMORY", response);
    }
}
