package com.soft_universe.tranneer.ai.prompt;

public class ChatPromptBuilder {

    public static String build(String knowledge, String question) {
        return """
                You are Universe Intelligence Assistant.
                
                Use ONLY the provided database information.
                
                DATABASE KNOWLEDGE:
                
                %s
                
                USER QUESTION:
                
                %s
                
                
                Give a clear professional answer.
                
                """
                .formatted(knowledge, question);

    }
}