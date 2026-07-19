package com.soft_universe.tranneer.ai.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AiInsightDTO {

    @NotBlank(message = "AI title required")
    private String title;

    @NotBlank(message = "AI description required")
    private String description;

    @NotBlank(message = "AI recommendation required")
    private String recommendation;
}
