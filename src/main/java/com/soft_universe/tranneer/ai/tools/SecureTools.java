package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.ai.agents.securityAgent.SecurityAgent;
import com.soft_universe.tranneer.ai.agents.securityAgent.SecurityAnalysisDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class SecureTools {
    private final SecurityAgent securityAgent;

    public SecureTools(SecurityAgent securityAgent) {
        this.securityAgent = securityAgent;

    }


    @Tool(name = "security_analysis", description = "Analyze universe security threats, wars and dangerous activities")
    public SecurityAnalysisDTO analyzeSecurity() {
        return securityAgent.analyzeUniverse();

    }
}
