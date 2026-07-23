package com.soft_universe.tranneer.ai.agents.researchAgent;

import org.springframework.stereotype.Component;

@Component
public class ResearchPromptBuilder {
    public String build(String data) {
        return """
                You are AlienBase Research AI.
                
                Analyze the following information.
                
                Information: %s
                
                {
                  "subject":"",
                  "findings":"",
                  "evidence":"",
                  "conclusion":"",
                  "recommendation":""
                }
                
                Requirements:
                - subject must identify the researched entity.
                - findings must summarize important discoveries.
                - evidence must use only provided information.
                - conclusion must summarize the research result.
                - recommendation must provide a useful action.
                - No markdown.
                - No explanation.
                - No text outside JSON.
                """
                .formatted(data);
    }
}
