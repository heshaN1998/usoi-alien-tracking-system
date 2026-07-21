package com.soft_universe.tranneer.ai.service;

import com.soft_universe.tranneer.ai.dtos.SecurityAnalysisDTO;

public interface SecurityAgent {
    SecurityAnalysisDTO analyzeUniverse();
    SecurityAnalysisDTO analyzeAlien(Long alienId);
    SecurityAnalysisDTO analyzePlanet(Long planetId);

}
