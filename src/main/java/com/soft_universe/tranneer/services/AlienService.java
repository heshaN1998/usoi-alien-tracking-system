package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.entities.Alien;

import java.util.List;
public interface AlienService {
    Alien saveAlien(Alien alien);
    Alien getAlienById(Long id);
    List<Alien> getAllAliens();
    void deleteAlien(Long id);
    Alien updateAlien(Long id,Alien alien);
}
