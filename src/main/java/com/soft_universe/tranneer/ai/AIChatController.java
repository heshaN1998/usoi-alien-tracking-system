package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.ChatRequestDTO;
import com.soft_universe.tranneer.ai.dtos.ChatResponseDTO;
import com.soft_universe.tranneer.ai.service.AIChatService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api01/chat")
public class AIChatController {
    private final AIChatService aiChatService;

    public AIChatController(AIChatService aiChatService) {
        this.aiChatService = aiChatService;
    }

    @PostMapping
    public ChatResponseDTO chat(@RequestBody ChatRequestDTO request) {
        return aiChatService.ask(request.getQuestion());
    }
}
