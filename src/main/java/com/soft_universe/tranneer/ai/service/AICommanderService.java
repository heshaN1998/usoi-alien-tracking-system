package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;

public interface AICommanderService {
    CommanderResponseDTO execute(String userId,String command);
}
