package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RecommendationDTO {
private RecommendationType type;
private String title;
private String recommendation;
private String priority;

}
