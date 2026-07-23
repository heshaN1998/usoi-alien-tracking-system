package com.soft_universe.tranneer.ai.agents.predictAgent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PredictionDTO {
private String predictionType;
private String subject;
private String probability;
private String prediction;
private String recommendation;

}
