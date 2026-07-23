package com.soft_universe.tranneer;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class GoogleConfigCheck {

    @Value("${spring.ai.google.genai.project-id:NOT_FOUND}")
    private String projectId;

    @Value("${spring.ai.google.genai.location:NOT_FOUND}")
    private String location;

    @Value("${spring.ai.google.genai.api-key:NOT_FOUND}")
    private String apiKey;


    @PostConstruct
    public void check() {
        System.out.println("========== GOOGLE GENAI CONFIG ==========");
        System.out.println("Project ID = " + projectId);
        System.out.println("Location  = " + location);
        System.out.println("API Key   = " +
                (apiKey.equals("NOT_FOUND") ? "NOT FOUND" : "FOUND"));
        System.out.println("=========================================");
    }
}