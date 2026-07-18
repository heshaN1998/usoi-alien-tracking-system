package com.soft_universe.tranneer.dtos.DasbordDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashbordSummeryDTO {

    private long totalAliens;
    private long totalPlanets;
    private long totalUsers;
    private double averageIq;

}
