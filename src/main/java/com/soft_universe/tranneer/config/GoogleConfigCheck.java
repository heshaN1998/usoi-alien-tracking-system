package com.soft_universe.tranneer.config;

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

}