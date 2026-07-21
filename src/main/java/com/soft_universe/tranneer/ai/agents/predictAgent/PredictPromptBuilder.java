package com.soft_universe.tranneer.ai.agents.predictAgent;

import org.springframework.stereotype.Component;

@Component
public class PredictPromptBuilder {
    public String build(String data, String type) {
        return """
                You are AlienBase Future Prediction AI.
                
                Analyze historical and current data.
                
                Prediction Type:
                
                %s
                
                Analyze:
                
                - Previous events
                - Current trends
                - Threat indicators
                - Growth patterns
                
                Provide:
                
                Prediction:
                Probability:
                Recommendation:
                
                Data:
                
                %s
                
                """
                .formatted(type, data);
    }
}
