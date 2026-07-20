package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.AIChatHistoryDTO;
import com.soft_universe.tranneer.ai.entity.AIChatHistory;
import com.soft_universe.tranneer.ai.repository.AIChatHistoryRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AIChatHistoryServiceIMPL implements AIChatHistoryService {
    private final AIChatHistoryRepository repository;

    public AIChatHistoryServiceIMPL(AIChatHistoryRepository repository) {
        this.repository = repository;

    }


    @Override
    public void saveChat(String userName, String question, String answer) {
        AIChatHistory history = AIChatHistory.builder()
                .userName(userName)
                .question(question)
                .answer(answer)
                .createdAt(LocalDateTime.now())
                .build();


        repository.save(history);

    }

    @Override
    public List<AIChatHistoryDTO> getHistory(String userName) {
        return repository.findTop20ByUserNameOrderByCreatedAtDesc(userName)
                .stream()
                .map(h -> new AIChatHistoryDTO(h.getQuestion(), h.getAnswer(), h.getCreatedAt())).toList();
    }
}
