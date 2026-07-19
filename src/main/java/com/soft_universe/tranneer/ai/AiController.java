package com.soft_universe.tranneer.ai;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api01/ai")
public class AiController {
    private final AiService aiService;
    public AiController(AiService aiService){
        this.aiService=aiService;
    }

    
    @GetMapping("/dashbord-insight")
    public List<AiInsightDTO> dashbordInsights(){
        return aiService.generateDashbordInsights();
    }
}
