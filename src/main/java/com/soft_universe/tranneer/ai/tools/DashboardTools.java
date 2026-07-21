package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.dtos.DasbordDTOs.DashbordSummeryDTO;
import com.soft_universe.tranneer.services.DashbordService;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("personal")
@Component
public class DashboardTools {
    private final DashbordService dashboardService;

    public DashboardTools(DashbordService dashboardService){
        this.dashboardService=dashboardService;

    }

    @Tool(name="dashboardSummary",description="Returns dashboard statistics")
    public DashbordSummeryDTO summary(){
        return dashboardService.getSummery();

    }
}
