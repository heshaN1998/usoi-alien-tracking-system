package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.agents.predictAgent.PredictionAgent;
import com.soft_universe.tranneer.ai.agents.researchAgent.ResearchAgent;
import com.soft_universe.tranneer.ai.agents.securityAgent.SecurityAgent;
import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;
import com.soft_universe.tranneer.ai.prompt.CommanderPromptBuilder;
import com.soft_universe.tranneer.ai.rag.KnowledgeRetriever;
import com.soft_universe.tranneer.repositories.PlanetRepository;
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

    //injecting my tripple agents
    private final SecurityAgent securityAgent;
    private final ResearchAgent researchAgent;
    private final PredictionAgent predictionAgent;
    public AICommanderServiceIMPL(ChatClient chatClient,
                                  KnowledgeRetriever retriever,
                                  CommanderPromptBuilder promptBuilder,
                                  SecurityAgent securityAgent,
                                  PredictionAgent predictionAgent,
                                  ResearchAgent researchAgent
    ) {
        this.chatClient = chatClient;
        this.retriever = retriever;
        this.promptBuilder = promptBuilder;
        this.securityAgent=securityAgent;
        this.predictionAgent=predictionAgent;
        this.researchAgent=researchAgent;

    }


    @Override
    public CommanderResponseDTO execute(String command) {

        String lowerCommand=command.toLowerCase();
        //for agents rout
        if (lowerCommand.contains("security")){
            return new CommanderResponseDTO("SECURITY ANALYSIS","CALL SECURITY AGENT",securityAgent.analyzeUniverse().toString());
        }

        if (lowerCommand.contains("research")){
            return new CommanderResponseDTO("RESEARCH ANALYSIS","CALL RESEARCH AGENT",researchAgent.investigateUniverse().toString());
        }

        if (lowerCommand.contains("prediction")){
            return new CommanderResponseDTO("PREDICTION ANALYSIS","CALL PREDICTION AGENT",predictionAgent.predictWar().toString());
        }

        //default AI reasoning[RAG]
        List<Document> docs = retriever.search(command);

        String context = docs.stream().map(Document::getText).collect(Collectors.joining());
        String prompt = promptBuilder.build(command, context);
        String answer = chatClient.prompt().user(prompt).call().content();

        return new CommanderResponseDTO("ANALYSIS COMPLETE", "EXICUTE", answer);
    }
}
