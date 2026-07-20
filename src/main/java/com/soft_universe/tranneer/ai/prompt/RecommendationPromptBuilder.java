package com.soft_universe.tranneer.ai.prompt;

import org.springframework.stereotype.Component;

@Component
public class RecommendationPromptBuilder {
        public String buildPrompt(String universeData){
            return """
                You are the AlienBase AI Strategic Advisor.

                Analyze the following universe data.

                Generate recommendations in these categories:

                1. Security
                2. Planet Management
                3. Alien Monitoring
                4. Resource Planning
                5. General Improvements

                Give concise recommendations with priority
                (HIGH, MEDIUM, LOW).

                Universe Data:

                %s
                """
                    .formatted(universeData);
        }
}
