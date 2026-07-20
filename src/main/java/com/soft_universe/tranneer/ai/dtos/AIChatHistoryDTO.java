package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AIChatHistoryDTO {
    private String question;
    private String answer;
    private LocalDateTime createdAt;
}
