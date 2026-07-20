package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.AIResponseDTO;
import com.soft_universe.tranneer.ai.dtos.AlienAIInsightDTO;
import com.soft_universe.tranneer.ai.dtos.PlanetAIInsightDTO;
import com.soft_universe.tranneer.ai.dtos.UniverseRiskDTO;

public interface AiService {
//    List<AiInsightDTO> generateDashbordInsights();
      AIResponseDTO generateDashbordInsights();
      PlanetAIInsightDTO analyzePlanet(Long planetId);
      AlienAIInsightDTO analyzeAlien(Long alienId);
      UniverseRiskDTO predictUniverseRisk();

}
