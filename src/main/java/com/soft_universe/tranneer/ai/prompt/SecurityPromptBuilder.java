package com.soft_universe.tranneer.ai.prompt;

import org.springframework.stereotype.Component;

@Component
public class SecurityPromptBuilder {
    public String build(String data) {
        return """
                You are AlienBase Security Intelligence Agent.
                
                Analyze the following universe information.
                
                Determine:
                
                1. Threat Level
                2. Dangerous entities
                3. Possible conflicts
                4. Security recommendation
                
                
                Rules:
                
                HIGH:
                - War planning
                - Powerful aliens
                - Extreme IQ combined with aggression
                
                MEDIUM:
                - Potential risks
                
                LOW:
                - Peaceful civilization
                
                Data:
                
                %s
                
                Return JSON:
                {
                "threatLevel":"",
                "target":"",
                "reason":"",
                "recommendation":""
                }
                """
                .formatted(data);
    }
}
