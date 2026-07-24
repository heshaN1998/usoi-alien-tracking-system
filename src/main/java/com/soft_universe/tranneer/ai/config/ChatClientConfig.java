package com.soft_universe.tranneer.ai.config;

import com.soft_universe.tranneer.ai.tools.*;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder,
                                 AlienTools alienTools,
                                 PlanetTools planetTools,
                                 PredictionTools predictionTools,
                                 RecommendationTools recommendationTools,
                                 SecurityTools securityTools) {

        return builder
                .defaultTools(alienTools,
                        planetTools,
                        predictionTools,
                        recommendationTools,
                        securityTools)
                .build();
    }
}