package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AiServiceIMPL implements AiService{
    private final ChatClient chatClient;
    private final AlienRepository alienRepository;
    private final PlanetRepository planetRepository;
    private final UserRepository userRepository;

    public AiServiceIMPL(ChatClient.Builder builder,AlienRepository alienRepository,PlanetRepository planetRepository,UserRepository userRepository){
        this.chatClient=builder.build();
        this.alienRepository=alienRepository;
        this.planetRepository=planetRepository;
        this.userRepository=userRepository;
    }

    @Override
    public List<AiInsightDTO> generateDashbordInsights() {
        long totalAliens = alienRepository.count();
        long totalPlanet = planetRepository.count();
        long totalUser = userRepository.count();
        Double avgIq = alienRepository.findAverageIq();

        if (avgIq == null) {
            avgIq = 0.0;
        }
        String prompt = """
                You are an AI Universe Analyst.
                
                Analyze this universe data:
                Total Aliens:
                %d
                
                Total Planets:
                %d
                
                Total Users:
                %d
                
                Average Alien IQ:
                %.2f
                
                Generate 3 important insights.
                
                Each insight must contain:
                
                title
                description
                recommendation
                
                Return ONLY JSON array.
                
                Example:
                
                [
                  {
                    "title":"Universe Status",
                    "description":"...",
                    "recommendation":"..."
                  }
                ]
                
                """.formatted(totalAliens, totalPlanet, totalUser, avgIq);

//      AIInsightDTO response = chatClient.prompt(prompt).call().entity(AIInsightDTO.class);
        AiInsightDTO response=chatClient.prompt(prompt).call().entity(new ParameterizedTypeReference<AiInsightDTO>() {});
        return List.of(response);
    }
}
