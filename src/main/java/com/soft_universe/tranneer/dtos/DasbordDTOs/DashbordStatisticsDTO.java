package com.soft_universe.tranneer.dtos.DasbordDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashbordStatisticsDTO {
    private long aliensWithPowers;
    private long aliensPlanningWar;
    private long planetsWithWar;
    private long peacefulPlanets;

}
