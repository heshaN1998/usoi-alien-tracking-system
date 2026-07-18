package com.soft_universe.tranneer.controllers;

import com.soft_universe.tranneer.dtos.DasbordDTOs.*;
import com.soft_universe.tranneer.services.DashbordService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api01/dashbord")
@CrossOrigin
public class DashbordController {

    private final DashbordService dashbordService;

    public DashbordController(DashbordService dashbordService){
        this.dashbordService = dashbordService;

    }


    @GetMapping("/summary")
    public DashbordSummeryDTO summary(){
        return dashbordService.getSummery();
    }


    @GetMapping("/statistics")
    public DashbordStatisticsDTO statistics(){
        return dashbordService.getStatistics();
    }


    @GetMapping("/charts")
    public List<DashbordChartDTO> charts(){
        return dashbordService.getChart();
    }


    @GetMapping("/alien-statistics")
    public AlienStatisticDTO alienStatistics(){
        return dashbordService.getAlienStatistics();
    }


    @GetMapping("/planet-statistics")
    public List<PlanetStatisticDTO> planetStatistics(){
        return dashbordService.getPlanetStatistics();
    }

}
