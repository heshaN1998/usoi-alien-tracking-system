package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.DasbordDTOs.*;
import com.soft_universe.tranneer.entities.Planet;
import com.soft_universe.tranneer.enums.IqLevel;
import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class DashbordServiceIMPL implements DashbordService{

    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final UserRepository userRepository;

    public DashbordServiceIMPL(AlienRepository alienRepository,PlanetRepository planetRepository,UserRepository userRepository){
        this.alienRepository=alienRepository;
        this.planetRepository=planetRepository;
        this.userRepository=userRepository;
    }

    @Override
    public DashbordSummeryDTO getSummery() {

        Double avg=alienRepository.findAverageIq();
        if (avg==null){
            avg=0.0;
        }
        return new DashbordSummeryDTO(alienRepository.count(), planetRepository.count(), userRepository.count(),avg);

    }


    @Override
    public DashbordStatisticsDTO getStatistics() {
        return new DashbordStatisticsDTO(
                alienRepository.countByHasPowersTrue(),
                alienRepository.countByPlanningWarTrue(),
                planetRepository.countByHasWarFalse(),
                planetRepository.countByHasWarTrue()
        );
    }

    @Override
    public List<DashbordChartDTO> getChart() {
        return List.of(
        new DashbordChartDTO("GENIOUS",alienRepository.countByIqLevel(IqLevel.GENIOUS)),
        new DashbordChartDTO("AVERAGE",alienRepository.countByIqLevel(IqLevel.AVERAGE)),
        new DashbordChartDTO("INGENIOUS",alienRepository.countByIqLevel(IqLevel.INGENIOUS)));

    }

    @Override
    public AlienStatisticDTO getAlienStatistics() {
        return new AlienStatisticDTO(
                alienRepository.countByIqLevel(IqLevel.GENIOUS),
                alienRepository.countByIqLevel(IqLevel.AVERAGE),
                alienRepository.countByIqLevel(IqLevel.INGENIOUS),
                alienRepository.countByHasPowersTrue()

        );
    }


    private double calculatePlanetAverageIQ(Planet planet){
        if (planet.getAliens()==null || planet.getAliens().isEmpty()){
            return 0;
        }
        return planet.getAliens().stream().mapToInt(a->a.getIq()).average().orElse(0);
    }

    @Override
    public List<PlanetStatisticDTO> getPlanetStatistics() {
        return planetRepository.findAll().stream().map(planet -> new PlanetStatisticDTO(
                planet.getPlanetId(),
                planet.getGalaxy(),
                planet.getAliens()==null ?0 :planet.getAliens().size(),calculatePlanetAverageIQ(planet),planet.isHasWar()

        )).toList();
    }
}
