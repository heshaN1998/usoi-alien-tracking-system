package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlienAIInsightDTO {
    private Long alienId;
    private String intelligenceLevel;
    private String threatLevel;
    private String powerClassification;
    private String analysis;
    private String recommendation;
}
