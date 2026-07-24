package com.soft_universe.tranneer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
@SpringBootTest
class TranneerApplicationTests {

    @Value("${spring.ai.google.genai.project-id}")
    String projectId;

    @Test
    void contextLoads() {
        System.out.println("PROJECT ID = " + projectId);

    }
}
