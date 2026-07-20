package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.AIChatHistoryDTO;

import java.util.List;

public interface AIChatHistoryService {
    void saveChat(String userName,String question,String answer);
    List<AIChatHistoryDTO> getHistory(String userName);
}
