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

    public AICommanderServiceIMPL(ChatClient chatClient,
                                  KnowledgeRetriever retriever,
                                  CommanderPromptBuilder promptBuilder,
                                  SecureTools secureTools,
                                  ReasearchTools reasearchTools,
                                  PredictTools predictTools,
                                  CommanderKnowledgeService knowledgeService,
                                  ChatMemory chatMemory
    ) {
        this.chatClient = chatClient;
        this.retriever = retriever;
        this.promptBuilder = promptBuilder;
        this.secureTools = secureTools;
        this.predictTools = predictTools;
        this.reasearchTools = reasearchTools;
        this.knowledgeService = knowledgeService;
        this.chatMemory=chatMemory;

    }


    @Override
    public CommanderResponseDTO execute(String userId,String command) {
        chatMemory.add(userId,new UserMessage(command));
        List<Message> historyMessage=chatMemory.get(userId,20);
        String history=historyMessage.stream().map(Message::getText).reduce("",(a,b)->a+ "\n"+ b );
        String knowledge = knowledgeService.retrieve(command);
//        List<Document> docs = retriever.search(command);

//        String context = docs.stream().map(Document::getText).collect(Collectors.joining("\n"));
//        String prompt = promptBuilder.build(command, context);
        String answer = chatClient.prompt()
                .system("""
                        You are AlienBase AI Commander.
                        
                        Remember previous conversations.
                        
                        You have access to:
                        
                        - Conversation Memory
                        - Retrieved Knowledge (RAG)
                        - AI Tools
                        
                        Use tools whenever they help answer the user's request.
                        """)

                .user("""
                        Conversation History:
                        
                         %s
                        
                        User Command:
                        
                        %s
                        
                        
                        Knowledge:
                        
                        %s
                        
                        """.formatted(history,command, knowledge)
                )
                .tools(secureTools, reasearchTools, predictTools)
                .call().
                content();

        chatMemory.add(userId,new AssistantMessage(answer));

//        return new CommanderResponseDTO("ANALYSIS COMPLETE", "EXICUTE", answer);
        return new CommanderResponseDTO("COMMANDER DECISION", "RAG ANALYSIS WITH TOOLS", answer);
    }
}
