package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanetAIInsightDTO {
    private String planet;
    private String dangerLevel;
    private String civilizationLevel;
    private String militaryThreat;
    private String analysis;
    private String recommendation;
}
