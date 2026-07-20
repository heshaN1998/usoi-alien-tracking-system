package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.ai.dtos.RecommendationDTO;
import com.soft_universe.tranneer.ai.service.AIRecommendationService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RecommendationTools {
    private final AIRecommendationService recommendationService;

    public RecommendationTools(AIRecommendationService recommendationService){
        this.recommendationService = recommendationService;

    }

    @Tool(name="generateRecommendations",description="Generates AI recommendations")
    public List<RecommendationDTO> recommendations(){
        return recommendationService.generateRecommendations();

    }
}
