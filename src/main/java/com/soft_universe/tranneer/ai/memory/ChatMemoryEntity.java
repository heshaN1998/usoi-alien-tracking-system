package com.soft_universe.tranneer.ai.memory;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ai_chat_memory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMemoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conversationId;
    private String role;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createdAt;

    @PrePersist
    public void Created(){
        createdAt= LocalDateTime.now();
    }
}
