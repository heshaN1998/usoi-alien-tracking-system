package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.AIChatHistoryDTO;
import com.soft_universe.tranneer.ai.dtos.ChatRequestDTO;
import com.soft_universe.tranneer.ai.dtos.ChatResponseDTO;
import com.soft_universe.tranneer.ai.service.AIChatHistoryService;
import com.soft_universe.tranneer.ai.service.AIChatService;
import com.soft_universe.tranneer.services.CurrentUserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api01/chat")
public class AIChatController {
    private final AIChatService aiChatService;
    private final CurrentUserService currentUserService;
    private final AIChatHistoryService chatHistoryService;

    public AIChatController(AIChatService aiChatService,CurrentUserService currentUserService,AIChatHistoryService chatHistoryService) {
        this.aiChatService = aiChatService;
        this.currentUserService=currentUserService;
        this.chatHistoryService=chatHistoryService;
    }

    @PostMapping
    public ChatResponseDTO chat(@RequestBody ChatRequestDTO request) {
        return aiChatService.ask(request.getQuestion());
    }

    public List<AIChatHistoryDTO> history(){
        String userName=currentUserService.getCurrentUsername();
        return chatHistoryService.getHistory(userName);
    }
}
