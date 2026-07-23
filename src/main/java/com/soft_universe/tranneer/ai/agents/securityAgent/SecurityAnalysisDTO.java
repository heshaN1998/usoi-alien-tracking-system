package com.soft_universe.tranneer.ai.agents.securityAgent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SecurityAnalysisDTO {
private String threatLevel;
private String target;
private String reason;
private String recommendation;
}
