package com.soft_universe.tranneer.entities;

import com.soft_universe.tranneer.enums.AlienType;
import com.soft_universe.tranneer.enums.IqLevel;
import com.soft_universe.tranneer.enums.PhysicalStrength;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Alientbl")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Min(value = 150, message = "iq should be at least 120")
    private int iq;
    @NotBlank(message = "must have plannet")
    private String planet;

    @NotNull(message = "type is required")
    @Enumerated(EnumType.STRING)
    private AlienType alienType;

    private String language;
    @Min(value = 1,message = "need in Earth Human years(365Earthday=1)")
    private int age;

    @NotNull(message = "IQ level required")
    @Enumerated(EnumType.STRING)
    private IqLevel iqLevel;

    @NotNull(message = "Physical strength required")
    @Enumerated(EnumType.STRING)
    private PhysicalStrength physicalStrength;

    private boolean planningWar;
    private boolean hasPowers;

    public Alien() {

    }

    public Alien(long id, int iq, String planet, AlienType alienType, String language, int age, IqLevel iqLevel, PhysicalStrength physicalStrength, boolean planningWar, boolean hasPowers) {
        this.id = id;
        this.iq = iq;
        this.planet = planet;
        this.alienType = alienType;
        this.language = language;
        this.age = age;
        this.iqLevel = iqLevel;
        this.physicalStrength = physicalStrength;
        this.planningWar = planningWar;
        this.hasPowers = hasPowers;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public void setAlienType(AlienType alienType) {
        this.alienType = alienType;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setIqLevel(IqLevel iqLevel) {
        this.iqLevel = iqLevel;
    }

    public void setPhysicalStrength(PhysicalStrength physicalStrength) {
        this.physicalStrength = physicalStrength;
    }

    public boolean isPlanningWar() {
        return planningWar;
    }

    public void setPlanningWar(boolean planningWar) {
        this.planningWar = planningWar;
    }

    public boolean isHasPowers() {
        return hasPowers;
    }

    public void setHasPowers(boolean hasPowers) {
        this.hasPowers = hasPowers;
    }

    public long getId() {
        return id;
    }

    public int getIq() {
        return iq;
    }

    public String getPlanet() {
        return planet;
    }

    public AlienType getAlienType() {
        return alienType;
    }

    public String getLanguage() {
        return language;
    }

    public IqLevel getIqLevel() {
        return iqLevel;
    }

    public PhysicalStrength getPhysicalStrength() {
        return physicalStrength;
    }

    public int getAge() {
        return age;
    }
}



// i also can used  @NoArgConstructor,@AllArgConstructr,@Data with lombork for this entity
