package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.RecommendationDTO;

import java.util.List;

public interface AIRecommendationService {
    List<RecommendationDTO> generateRecommendations();
}
