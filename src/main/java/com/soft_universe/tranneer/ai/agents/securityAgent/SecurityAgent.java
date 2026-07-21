package com.soft_universe.tranneer.ai.agents.securityAgent;

public interface SecurityAgent {
    SecurityAnalysisDTO analyzeUniverse();
    SecurityAnalysisDTO analyzeAlien(Long alienId);
    SecurityAnalysisDTO analyzePlanet(Long planetId);

}
