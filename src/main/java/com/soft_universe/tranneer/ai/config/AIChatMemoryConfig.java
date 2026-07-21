package com.soft_universe.tranneer.ai.config;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AIChatMemoryConfig {
    @Bean
    public ChatMemory chatMemory(){
        return new InMemoryChatMemory();

    }
}