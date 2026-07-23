package com.soft_universe.tranneer.ai.agents.predictAgent;

import org.springframework.stereotype.Component;

@Component
public class PredictPromptBuilder {
    public String build(String data, String type) {
        return """
                
                You are AlienBase Future Prediction AI.
                
                Analyze the provided data.
                
                Prediction Type:
                %s
                
                Data:
                %s
                
                Return ONLY valid JSON.
                
                {
                  "predictionType": "",
                  "subject": "",
                  "probability": "",
                  "prediction": "",
                  "recommendation": ""
                }
                
                 Rules:
                 - Probability should be a percentage (example: "82%%")
                 - Keep prediction under 50 words.
                 - Keep recommendation under 40 words.
                 - Do not return markdown.
                 - Do not explain anything.
                 - Return JSON only.
                
                """


                .formatted(type, data);
    }
}
