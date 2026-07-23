package com.soft_universe.tranneer.ai.config;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.memory.ChatMemoryRepository;
import org.springframework.ai.chat.memory.InMemoryChatMemoryRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AIChatMemoryConfig {
    @Bean
    public ChatMemoryRepository aiChatMemoryRepository(){
        return new InMemoryChatMemoryRepository();

    }
}