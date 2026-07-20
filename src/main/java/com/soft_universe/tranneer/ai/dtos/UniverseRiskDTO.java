package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UniverseRiskDTO {
    private String overallRisk;
    private double riskScore;
    private String civilizationStatus;
    private String warProbability;
    private String analysis;
    private String recommendation;
}
