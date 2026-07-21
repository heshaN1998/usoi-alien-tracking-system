package com.soft_universe.tranneer.ai.tools;

import com.soft_universe.tranneer.ai.agents.predictAgent.PredictionAgent;
import com.soft_universe.tranneer.ai.agents.predictAgent.PredictionDTO;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

@Component
public class PredictTools {
    private final PredictionAgent predictionAgent;

    public PredictTools(PredictionAgent predictionAgent){
        this.predictionAgent = predictionAgent;

    }

    @Tool(name="predict_future_war", description="Predict possible future wars and conflicts")
    public PredictionDTO predictWar(){
        return predictionAgent.predictWar();

    }
}
