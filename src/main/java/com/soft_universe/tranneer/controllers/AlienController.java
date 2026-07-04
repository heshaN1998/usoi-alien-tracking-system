package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.services.AlienService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api01/aliens")
public class AlienController {
    private final AlienService alienService;
    public AlienController(AlienService alienService){
        this.alienService=alienService;
    }

    @PostMapping
    public Alien createAlien(@RequestBody Alien alien){
        return alienService.saveAlien(alien);
    }
    @GetMapping("/{id}")
    public Alien getAlianById(@PathVariable long id){
        return alienService.getAlienById(id);
    }
    @GetMapping
    public List<Alien> getAllAliens(){
        return alienService.getAllAliens();
    }
    public void deleteAlien(@PathVariable long id){
        alienService.deleteAlien(id);
    }
    @PostMapping
    public Alien updateAlian(@PathVariable long id, @RequestBody Alien alien){
        return alienService.updateAlien(id,alien);
    }
}
