package com.soft_universe.tranneer.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.soft_universe.tranneer.enums.PlanetType;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "planetTbl")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Planet extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planetId;

    //adding Relation
    @JsonIgnore
    @OneToMany(mappedBy = "planet")
    private List<Alien> aliens;

    private String galaxy;

    @Enumerated(EnumType.STRING)
    private PlanetType planetType;

    private String timeFrame;
    private Double avgIQ;
    private String relativeGravity;
    private int knowledgeLevel;
    private int alienCount;
    private boolean hasWar;

}
