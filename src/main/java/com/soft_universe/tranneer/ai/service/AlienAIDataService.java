package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.exceptions.AlienNotFoundException;
import com.soft_universe.tranneer.repositories.AlienRepository;
import org.springframework.stereotype.Service;

@Service
public class AlienAIDataService {
    private final AlienRepository alienRepository;

    public AlienAIDataService(AlienRepository alienRepository){
        this.alienRepository=alienRepository;
    }

    public Alien getAlien(Long id){
        return alienRepository.findById(id).orElseThrow(()->new AlienNotFoundException("Alien not found"));
    }
}
