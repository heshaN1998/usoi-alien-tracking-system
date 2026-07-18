package com.soft_universe.tranneer.services;

import com.soft_universe.tranneer.dtos.DasbordDTOs.*;

import java.util.List;

public interface DashbordService {
    DashbordSummeryDTO getSummery();
    DashbordStatisticsDTO getStatistics();
    List<DashbordChartDTO> getChart();
    AlienStatisticDTO getAlienStatistics();
    List<PlanetStatisticDTO> getPlanetStatistics();
}
