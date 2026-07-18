package com.soft_universe.tranneer.dtos.DasbordDTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanetStatisticDTO {
    private Long planetId;
    private String galaxy;
    private long alienCount;
    private double averageIq;
    private boolean hasWar;
}
