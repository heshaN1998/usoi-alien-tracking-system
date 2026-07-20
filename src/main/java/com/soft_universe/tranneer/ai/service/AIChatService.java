package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.ChatResponseDTO;

public interface AIChatService {
    ChatResponseDTO ask(String question);
}
