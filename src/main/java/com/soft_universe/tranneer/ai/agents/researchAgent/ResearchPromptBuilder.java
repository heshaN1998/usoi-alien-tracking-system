package com.soft_universe.tranneer.ai.agents.researchAgent;

import org.springframework.stereotype.Component;

@Component
public class ResearchPromptBuilder {
    public String build(String data) {
        return """
                You are an AI Research Agent for AlienBase.
                
                        Your job is to investigate the provided information.
                
                        Produce a JSON response with:
                        {
                          "subject":"",
                          "findings":"",
                          "evidence":"",
                          "conclusion":"",
                          "recommendation":""
                        }
                
                        Information:
                
                        %s
                """
                .formatted(data);
    }
}
