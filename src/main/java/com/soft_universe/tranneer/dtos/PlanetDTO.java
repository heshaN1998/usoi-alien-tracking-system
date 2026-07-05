package com.soft_universe.tranneer.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.enums.PlanetType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PlanetDTO {
    private Long planetId;
    private String galaxy;
    private PlanetType planetType;
    private String timeFrame;
    private Double avgIQ;
    private String relativeGravity;
    private int knowledgeLevel;
    private int alienCount;
    private boolean hasWar;

}
