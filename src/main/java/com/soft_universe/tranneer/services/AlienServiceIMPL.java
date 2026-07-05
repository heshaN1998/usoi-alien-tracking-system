package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.RequestDTO;
import com.soft_universe.tranneer.dtos.ResponseDTO;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.exceptions.AlienNotFoundException;
import com.soft_universe.tranneer.mapper.DtoEntityMapper;
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
    public ResponseDTO saveAlien(RequestDTO dto) {
        Alien alien= DtoEntityMapper.dtoToEntity(dto);
        Alien saved=alienRepository.save(alien);
        return DtoEntityMapper.entityToDto(saved);
    }

    @Override
    public ResponseDTO getAlienById(Long id) {
       Alien alien= alienRepository.findById(id).orElseThrow(()->new AlienNotFoundException("Alien not found"));
        return DtoEntityMapper.entityToDto(alien);
    }

    @Override
    public List<ResponseDTO> getAllAliens() {
        return alienRepository.findAll().stream().map(DtoEntityMapper::entityToDto).toList();
    }

    @Override
    public void deleteAlien(Long id) {
        alienRepository.deleteById(id);
    }

    @Override
    public ResponseDTO updateAlien(Long id, RequestDTO updatingAlien) {
    Alien existing=alienRepository.findById(id).orElseThrow(()->new AlienNotFoundException("alien doesnt exist in database"));
    existing.setIq(updatingAlien.getIq());
    existing.setIqLevel(updatingAlien.getIqLevel());
    existing.setPlanet(updatingAlien.getPlanet());
    existing.setAlienType(updatingAlien.getAlienType());
    existing.setLanguage(updatingAlien.getLanguage());
    existing.setAge(updatingAlien.getAge());
    existing.setPhysicalStrength(updatingAlien.getPhysicalStrength());
    existing.setPlanningWar(updatingAlien.isPlanningWar());
    existing.setHasPowers(updatingAlien.isHasPowers());
    Alien saved=alienRepository.save(existing);
    return DtoEntityMapper.entityToDto(saved);
    }
}
