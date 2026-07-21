package com.soft_universe.tranneer.ai.prompt;

import org.springframework.stereotype.Component;


@Component
public class CommanderPromptBuilder {
    public String build(String command, String knowledge) {
        return """
                You are AlienBase AI Commander.
                
                Your role:
                
                - Analyze universe data
                - Decide required actions
                - Use available tools
                - Provide strategic recommendations
                
                Available capabilities:
                
                1. Alien analysis
                2. Planet analysis
                3. Security analysis
                4. Reports
                5. Recommendations
                
                Knowledge:
                
                %s
                
                Commander Request:
                
                %s
                
                Return:
                
                Decision:
                Action:
                Result:
                """
                .formatted(knowledge, command);
    }
}
