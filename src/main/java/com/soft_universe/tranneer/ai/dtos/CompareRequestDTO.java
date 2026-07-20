package com.soft_universe.tranneer.ai.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompareRequestDTO {
private ComparisonType type;
private Long firstId;
private Long secondId;
}
