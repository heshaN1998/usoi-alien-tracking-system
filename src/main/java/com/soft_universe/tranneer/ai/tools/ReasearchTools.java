package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.ai.agents.researchAgent.ResearchAgent;
import com.soft_universe.tranneer.ai.agents.researchAgent.ResearchDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class ReasearchTools {
    private final ResearchAgent researchAgent;

    public ReasearchTools(ResearchAgent researchAgent) {
        this.researchAgent = researchAgent;

    }

    @Tool(name = "research_universe", description = "Research universe history and stored knowledge using RAG")
    public ResearchDTO researchUniverse() {
        return researchAgent.investigateUniverse();

    }
}

