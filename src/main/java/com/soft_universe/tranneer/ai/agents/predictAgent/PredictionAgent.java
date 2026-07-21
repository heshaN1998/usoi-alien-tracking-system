package com.soft_universe.tranneer.ai.agents.predictAgent;

public interface PredictionAgent {
    PredictionDTO predictWar();
    PredictionDTO predictWar(Long planetId);
    PredictionDTO predictAlienThreat(Long alienId);

}
