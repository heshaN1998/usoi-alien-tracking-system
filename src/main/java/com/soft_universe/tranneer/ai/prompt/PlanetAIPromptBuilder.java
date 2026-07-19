package com.soft_universe.tranneer.ai.prompt;

public class PlanetAIPromptBuilder {
    public static String build(String data) {
        return """
                You are a universe intelligence analyst.
                
                Analyze this planet:
                
                %s
                
                Return ONLY JSON.
                
                Format:
                
                {
                "planet":"",
                "dangerLevel":"",
                "civilizationLevel":"",
                "militaryThreat":"",
                "analysis":"",
                "recommendation":""
                }
                
                Possible danger levels:
                
                LOW
                MEDIUM
                HIGH
                EXTREME
                
                Possible civilization:
                
                PRIMITIVE
                DEVELOPING
                ADVANCED
                SUPERIOR
                
                Possible military threat:
                
                NONE
                LOW
                MEDIUM
                HIGH
                EXTREME
                
                """.formatted(data);
    }
}
