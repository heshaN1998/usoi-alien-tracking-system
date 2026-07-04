package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.entities.Alien;

import java.util.List;
public interface AlienService {
    Alien saveAlien(Alien alien);
    Alien getAlienById(long id);
    List<Alien> getAllAliens();
    void deleteAlien(long id);
    Alien updateAlien(long id,Alien alien);
}
