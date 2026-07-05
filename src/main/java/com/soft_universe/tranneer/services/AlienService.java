package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.RequestDTO;
import com.soft_universe.tranneer.dtos.ResponseDTO;
import com.soft_universe.tranneer.entities.Alien;

import java.util.List;
public interface AlienService {
    ResponseDTO saveAlien(RequestDTO dto);
    ResponseDTO getAlienById(Long id);
    List<ResponseDTO> getAllAliens();
    void deleteAlien(Long id);
    ResponseDTO updateAlien(Long id,RequestDTO dto);
}
