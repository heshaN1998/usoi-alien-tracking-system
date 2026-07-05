package com.soft_universe.tranneer.dtos;

import com.soft_universe.tranneer.enums.AlienType;
import com.soft_universe.tranneer.enums.IqLevel;
import com.soft_universe.tranneer.enums.PhysicalStrength;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequestDTO {
    private int iq;
    private String planet;
    private AlienType alienType;
    private String language;
    private int age;
    private IqLevel iqLevel;
    private PhysicalStrength physicalStrength;
    private boolean planningWar;
    private boolean hasPowers;

}
