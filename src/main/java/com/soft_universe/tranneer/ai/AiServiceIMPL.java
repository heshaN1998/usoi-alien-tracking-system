package com.soft_universe.tranneer.ai;

import com.soft_universe.tranneer.repositories.AlienRepository;
import com.soft_universe.tranneer.repositories.PlanetRepository;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class AiServiceIMPL {
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
}
