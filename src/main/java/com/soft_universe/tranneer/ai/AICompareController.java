package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.CompareRequestDTO;
import com.soft_universe.tranneer.ai.dtos.CompareResponseDTO;
import com.soft_universe.tranneer.ai.service.AICompareService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai/compare")
public class AICompareController {
    private final AICompareService compareService;

    public AICompareController(AICompareService compareService){
        this.compareService = compareService;
    }


    @PostMapping
    public CompareResponseDTO compare(@RequestBody CompareRequestDTO request){
        return compareService.compare(request);
    }
}
