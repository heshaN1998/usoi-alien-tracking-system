package com.soft_universe.tranneer.ai.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommanderResponseDTO {
    private String decision;
    private String action;
    private String result;
}
