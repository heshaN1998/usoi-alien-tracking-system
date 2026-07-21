package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.ai.dtos.CommanderRequestDTO;
import com.soft_universe.tranneer.ai.dtos.CommanderResponseDTO;
import com.soft_universe.tranneer.ai.service.AICommanderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ai/commander")
public class AICommanderController {
    private final AICommanderService service;

    public AICommanderController(AICommanderService service){
        this.service=service;
    }

    @PostMapping
    public ResponseEntity<CommanderResponseDTO> command(@RequestBody CommanderRequestDTO request){
        CommanderResponseDTO response=service.execute(request.getCommand());
        return ResponseEntity.ok(response);
    }
}
