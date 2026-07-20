package com.soft_universe.tranneer.ai.prompt;

public class UniverseRiskPromptBuilder {

    public static String build(String data) {
        return """
                
                You are a universe security intelligence AI.
                
                Analyze the following universe data:
                
                %s
                
                Return ONLY JSON.
                
                Format:
                {
                
                "overallRisk":"",
                "riskScore":"",
                "civilizationStatus":"",
                "warProbability":"",
                "analysis":"",
                "recommendation":""0
                
                }
                
                Rules:
                
                overallRisk:
                
                SAFE
                LOW
                MEDIUM
                HIGH
                CRITICAL
                
                civilizationStatus:
                
                PRIMITIVE
                DEVELOPING
                ADVANCED
                SUPERIOR
                
                warProbability:
                
                LOW
                MEDIUM
                HIGH
                EXTREME
                
                
                """
                .formatted(data);

    }
}
