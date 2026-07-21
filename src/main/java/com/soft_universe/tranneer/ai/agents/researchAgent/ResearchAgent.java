package com.soft_universe.tranneer.ai.agents.researchAgent;

public interface ResearchAgent {
    ResearchDTO investigateUniverse();
    ResearchDTO investigatePlanet(Long planetId);
    ResearchDTO investigateAlien(Long alienId);

}
