package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.CompareRequestDTO;
import com.soft_universe.tranneer.ai.dtos.CompareResponseDTO;

public interface AICompareService {
    CompareResponseDTO compare(CompareRequestDTO request);
}
