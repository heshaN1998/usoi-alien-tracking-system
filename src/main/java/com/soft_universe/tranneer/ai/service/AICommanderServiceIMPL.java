package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.agents.predictAgent.PredictionAgent;
import com.soft_universe.tranneer.ai.agents.researchAgent.ResearchAgent;
import com.soft_universe.tranneer.ai.agents.securityAgent.SecurityAgent;
import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;
import com.soft_universe.tranneer.ai.prompt.CommanderPromptBuilder;
import com.soft_universe.tranneer.ai.rag.CommanderKnowledgeService;
import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.ai.tools.PredictTools;
import com.soft_universe.tranneer.ai.tools.ReasearchTools;
import com.soft_universe.tranneer.ai.tools.SecureTools;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AICommanderServiceIMPL implements AICommanderService {
    private final ChatClient chatClient;
    private final KnowledgeRetriever retriever;
    private final CommanderPromptBuilder promptBuilder;

    private final SecureTools secureTools;
    private final ReasearchTools reasearchTools;
    private final PredictTools predictTools;
    private final CommanderKnowledgeService knowledgeService;

    public AICommanderServiceIMPL(ChatClient chatClient,
                                  KnowledgeRetriever retriever,
                                  CommanderPromptBuilder promptBuilder,
                                  SecureTools secureTools,
                                  ReasearchTools reasearchTools,
                                  PredictTools predictTools,
                                  CommanderKnowledgeService knowledgeService
    ) {
        this.chatClient = chatClient;
        this.retriever = retriever;
        this.promptBuilder = promptBuilder;
        this.secureTools = secureTools;
        this.predictTools = predictTools;
        this.reasearchTools = reasearchTools;
        this.knowledgeService = knowledgeService;

    }


    @Override
    public CommanderResponseDTO execute(String command) {
        String knowledge = knowledgeService.retrieve(command);
//        List<Document> docs = retriever.search(command);

//        String context = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
//        String prompt = promptBuilder.build(command, context);
        String answer = chatClient.prompt()
                .system("""
                        
                        You are AlienBase AI Commander.
                        
                        You can:
                        - call tools
                        - analyze knowledge
                        - make decisions
                        
                        Always use tools when required.
                        
                        """)
                .user("""
                        
                        User Command:
                        
                        %s
                        
                        
                        Knowledge:
                        
                        %s
                        
                        """.formatted(
                        command,
                        knowledge
                ))
                .tools(secureTools, reasearchTools, predictTools)
                .call().
                content();

//        return new CommanderResponseDTO("ANALYSIS COMPLETE", "EXICUTE", answer);
        return new CommanderResponseDTO("COMMANDER DECISION", "RAG ANALYSIS WITH TOOLS", answer);
    }
}
