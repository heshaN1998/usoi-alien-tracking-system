package com.soft_universe.tranneer.ai.config;

import com.soft_universe.tranneer.ai.tools.AlienTools;
import com.soft_universe.tranneer.ai.tools.DashboardTools;
import com.soft_universe.tranneer.ai.tools.PlanetTools;
import com.soft_universe.tranneer.ai.tools.RecommendationTools;
import org.springframework.ai.tool.ToolCallbackProvider;
import org.springframework.ai.tool.method.MethodToolCallbackProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToolConfigurations {
    @Bean
    ToolCallbackProvider toolCallbackProvider(AlienTools alienTools,PlanetTools planetTools,DashboardTools dashboardTools,RecommendationTools recommendationTools){
        return MethodToolCallbackProvider.builder()
                .toolObjects(alienTools,planetTools, dashboardTools, recommendationTools)
                .build();
    }
}
