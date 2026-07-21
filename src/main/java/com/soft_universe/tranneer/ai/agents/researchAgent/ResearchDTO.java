package com.soft_universe.tranneer.ai.agents.researchAgent;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Getter
@Service
@NoArgsConstructor
@AllArgsConstructor
public class ResearchDTO {
    private String subject;
    private String findings;
    private String evidence;
    private String conclusion;
    private String recommendation;

}
