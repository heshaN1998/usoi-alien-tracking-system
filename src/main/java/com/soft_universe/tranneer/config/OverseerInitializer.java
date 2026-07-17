package com.soft_universe.tranneer.config;

import com.soft_universe.tranneer.entities.Role;
import com.soft_universe.tranneer.entities.User;
import com.soft_universe.tranneer.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class OverseerInitializer {

    //overseer means admin who have only main authorized one
    CommandLineRunner createOverseer(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if (userRepository.findUserName("admin").isEmpty()) {
                User overseer = User.builder()
                        .userName("overseer")
                        .password(passwordEncoder.encode("PoweredAdmin18"))
                        .role(Role.OVERSEER)
                        .build();

                userRepository.save(overseer);

                System.out.println("Default powered OVERSEER admin created");
            }
        };
    }
}
