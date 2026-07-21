package com.soft_universe.tranneer.ai.agents.predictAgent;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PredictionDTO {
private String predictionType;
private String subject;
private String probability;
private String prediction;
private String recommendation;

}
