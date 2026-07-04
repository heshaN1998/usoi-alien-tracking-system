package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.repositories.AlienRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlienServiceIMPL implements AlienService{

    private final AlienRepository alienRepository;
    public AlienServiceIMPL(AlienRepository alienRepository){
        this.alienRepository=alienRepository;
    }
    @Override
    public Alien saveAlien(Alien alien) {
        return alienRepository.save(alien);
    }

    @Override
    public Alien getAlienById(long id) {
       return alienRepository.findById(id).orElseThrow(()->new RuntimeException("Alien not found"));
    }

    @Override
    public List<Alien> getAllAliens() {
        return alienRepository.findAll();
    }

    @Override
    public void deleteAlien(long id) {
        alienRepository.deleteById(id);
    }

    @Override
    public Alien updateAlien(long id, Alien updatingAlien) {
    Alien existing=alienRepository.findById(id).orElseThrow(()->new RuntimeException("alien doesnt exist in database"));
    existing.setIq(updatingAlien.getIq());
    existing.setPlanet(updatingAlien.getPlanet());
    existing.setAlienType(updatingAlien.getAlienType());
    existing.setLanguage(updatingAlien.getLanguage());
    existing.setAge(updatingAlien.getAge());
    existing.setPhysicalStrength(updatingAlien.getPhysicalStrength());
    existing.setPlanningWar(updatingAlien.isPlanningWar());
    existing.setHasPowers(updatingAlien.isHasPowers());

    return alienRepository.save(existing);
    }
}
