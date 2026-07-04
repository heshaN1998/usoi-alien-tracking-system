package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.services.AlienService;
import jakarta.validation.Valid;
import jdk.jfr.ContentType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api01/aliens")
@CrossOrigin
public class AlienController {
    private final AlienService alienService;
    public AlienController(AlienService alienService){
        this.alienService=alienService;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    public Alien createAlien(@Valid @RequestBody Alien alien) {
        return alienService.saveAlien(alien);
    }
    @GetMapping("/{id}")
    public Alien getAlianById(@PathVariable Long id){
        return alienService.getAlienById(id);
    }
    @GetMapping
    public List<Alien> getAllAliens(){
        return alienService.getAllAliens();
    }
    @DeleteMapping("/{id}")
    public void deleteAlien(@PathVariable Long id){
        alienService.deleteAlien(id);
    }
    @PutMapping("/{id}")
    public Alien updateAlian( @PathVariable Long id, @Valid @RequestBody Alien alien){
        return alienService.updateAlien(id,alien);
    }
}
