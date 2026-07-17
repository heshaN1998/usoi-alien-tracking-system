package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.dtos.PlanetDTO;
import com.soft_universe.tranneer.services.PlanetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api01/planets")
@CrossOrigin
public class PlanetController {
    private final PlanetService planetService;

    public PlanetController(PlanetService planetService){
        this.planetService=planetService;
    }

    @PostMapping
    public PlanetDTO createPlanet(@RequestBody PlanetDTO dto){
        return planetService.savePlanet(dto);
    }

    @GetMapping("/{id")
    public PlanetDTO getPlanetById(@PathVariable Long id){
        return planetService.getPlanetById(id);
    }

    @GetMapping
    public List<PlanetDTO> getAllPlanets(){
        return planetService.getAllPlanets();
    }

    @DeleteMapping("/{id}")
    public void deletePlanet(@PathVariable Long id){
        planetService.deletePlanet(id);
    }

    @GetMapping("/{id}")
    public PlanetDTO updatePlanet(@PathVariable Long id,@RequestBody PlanetDTO dto){
        return planetService.updatePlanet(id,dto);
    }

}
