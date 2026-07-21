package com.soft_universe.tranneer.ai.agents.securityAgent;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SecurityAnalysisDTO {
private String threatLevel;
private String target;
private String reason;
private String recommendation;
}
