package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.AIResponseDTO;
import com.soft_universe.tranneer.ai.dtos.AlienAIInsightDTO;
import com.soft_universe.tranneer.ai.dtos.PlanetAIInsightDTO;
import com.soft_universe.tranneer.ai.dtos.UniverseRiskDTO;
import com.soft_universe.tranneer.ai.service.AiService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai")
public class AiController {
    private final AiService aiService;
    public AiController(AiService aiService){
        this.aiService=aiService;
    }


    @GetMapping("/dashbord-insight")
    public AIResponseDTO dashbordInsights(){
        return aiService.generateDashbordInsights();
    }

    @GetMapping("/planet/{id}")
    public PlanetAIInsightDTO analyzePlanet(@PathVariable Long id){
        return aiService.analyzePlanet(id);
    }

    @GetMapping("/alien/{id}")
    public AlienAIInsightDTO analyzeAlien(@PathVariable Long id){
        return aiService.analyzeAlien(id);
    }

    @GetMapping("/universe/risk")
    public UniverseRiskDTO universeRiskDTO(){
        return aiService.predictUniverseRisk();
    }

}
