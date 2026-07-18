package com.soft_universe.tranneer.mapper;

import com.soft_universe.tranneer.dtos.RequestDTO;
import com.soft_universe.tranneer.dtos.ResponseDTO;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.entities.Planet;
import org.springframework.stereotype.Component;

@Component
public class DtoEntityMapper {
    public static Alien dtoToEntity(RequestDTO dto, Planet planet){
        Alien alien=new Alien();
        alien.setIq(dto.getIq());
        alien.setPlanet(planet);
        alien.setAlienType(dto.getAlienType());
        alien.setLanguage(dto.getLanguage());
        alien.setAge(dto.getAge());
        alien.setIqLevel(dto.getIqLevel());
        alien.setPhysicalStrength(dto.getPhysicalStrength());
        alien.setPlanningWar(dto.isPlanningWar());
        alien.setHasPowers(dto.isHasPowers());
        return alien;
    }

    public static ResponseDTO entityToDto(Alien alien){
        ResponseDTO dto=new ResponseDTO();
        dto.setId(alien.getId());
        dto.setIq(alien.getIq());
        if(alien.getPlanet() != null){
            dto.setPlanetId(alien.getPlanet().getPlanetId());
        }
        dto.setAlienType(alien.getAlienType());
        dto.setLanguage(alien.getLanguage());
        dto.setAge(alien.getAge());
        dto.setIqLevel(alien.getIqLevel());
        dto.setPhysicalStrength(alien.getPhysicalStrength());
        dto.setPlanningWar(alien.isPlanningWar());
        dto.setHasPowers(alien.isHasPowers());
        dto.setCreatedBy(alien.getCreatedBy());
        dto.setUpdatedBy(alien.getUpdatedBy());
        dto.setCreatedAt(alien.getCreatedAt());
        dto.setUpdatedAt(alien.getUpdatedAt());
        return dto;

    }
}


