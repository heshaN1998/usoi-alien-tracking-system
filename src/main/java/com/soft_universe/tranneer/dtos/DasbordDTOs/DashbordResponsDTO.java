package com.soft_universe.tranneer.dtos.DasbordDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashbordResponsDTO {
    private  DashbordSummeryDTO summery;
    private DashbordStatisticsDTO statistics;
    private List<DashbordChartDTO> chart;
    private List<PlanetStatisticDTO> planets;
    private AlienStatisticDTO alienStatistics;
    private List<RecentActivityDTO> recentActivities;

}
