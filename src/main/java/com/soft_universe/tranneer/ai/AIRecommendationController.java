package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.RecommendationDTO;
import com.soft_universe.tranneer.ai.service.AIRecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ai/recommendation")
public class AIRecommendationController {
    private final AIRecommendationService service;

    public AIRecommendationController(AIRecommendationService service){
        this.service=service;
    }

    @GetMapping
    public List<RecommendationDTO> recommendations(){
        return service.generateRecommendations();
    }

}
