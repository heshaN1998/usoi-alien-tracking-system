package com.soft_universe.tranneer.ai;

public class AIPromptBuilder {
    public static String dashboardInsightPrompt(
            long aliens,
            long planets,
            long users,
            double averageIQ
    ){
        return """
        You are a professional universe intelligence analyst.

        Analyze:

        Total Aliens:
        %d

        Total Planets:
        %d

        Total Users:
        %d
        
        Average IQ:
        %.2f

        Generate exactly 3 insights.

        Return ONLY JSON.

        JSON format:
        {
          "insights":[
             {
              "title":"",
              "description":"",
              "recommendation":""
             }
          ]
        }

        """.formatted(aliens,planets,users,averageIQ);
    }
}