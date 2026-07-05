package com.soft_universe.tranneer.mapper;

import com.soft_universe.tranneer.dtos.RequestDTO;
import com.soft_universe.tranneer.dtos.ResponseDTO;
import com.soft_universe.tranneer.entities.Alien;
import org.springframework.stereotype.Component;

@Component
public class DtoEntityMapper {
    public static Alien dtoToEntity(RequestDTO dto){
        Alien alien=new Alien();
        alien.setIq(dto.getIq());
        alien.setPlanet(dto.getPlannet());
        alien.setAlienType(dto.getAlienType());
        alien.setLanguage(dto.getLanguage());
        alien.setAge(dto.getAge());
        alien.setIqLevel(dto.getIqLevel());
        alien.setPhysicalStrength(dto.getPhysicalStrength());
        alien.setPlanningWar(dto.isPlanningWar());
        alien.setHasPowers(dto.isHasPower());
        return alien;
    }

    public static ResponseDTO entityToDto(Alien alien){
        ResponseDTO dto=new ResponseDTO();
        dto.setId(alien.getId());
        dto.setIq(alien.getIq());;
        dto.setPlannet(alien.getPlanet());
        dto.setAlienType(alien.getAlienType());
        dto.setLanguage(alien.getLanguage());
        dto.setAge(alien.getAge());
        dto.setIqLevel(alien.getIqLevel());
        dto.setPhysicalStrength(alien.getPhysicalStrength());
        dto.setPlanningWar(alien.isPlanningWar());
        dto.setHasPower(alien.isHasPowers());
        return dto;

    }
}


