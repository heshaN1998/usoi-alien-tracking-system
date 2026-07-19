package com.soft_universe.tranneer.ai.prompt;

public class AlienAIPromptBuilder {
    public static String build(String data){
        return """
                You are an advanced alien intelligence analyst.
                
                Analyze this alien:
                
                
                %s
                
                Return ONLY JSON.
                
                Format:
                {
                
                "alienId":"",
                "intelligenceLevel":"",
                "threatLevel":"",
                "powerClassification":"",
                "analysis":"",
                "recommendation":""
                
                }
                
                Rules:
                
                intelligenceLevel:
                
                LOW
                AVERAGE
                HIGH
                GENIUS
                
                threatLevel:
                
                SAFE
                LOW
                MEDIUM
                HIGH
                EXTREME
                
                powerClassification:
                
                NORMAL
                ENHANCED
                SUPERIOR
                UNKNOWN
                """
                .formatted(data);
    }
}
