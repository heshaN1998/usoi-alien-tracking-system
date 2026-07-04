package com.soft_universe.tranneer.entities;

import com.soft_universe.tranneer.enums.AlienType;
import com.soft_universe.tranneer.enums.IqLevel;
import com.soft_universe.tranneer.enums.PhysicalStrength;
import jakarta.persistence.*;
@Entity
@Table(name = "Alientbl")
public class Alien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int iq;
    private String planet;

    @Enumerated(EnumType.STRING)
    private AlienType alienType;

    private String language;
    private int age;

    @Enumerated(EnumType.STRING)
    private IqLevel iqLevel;

    @Enumerated(EnumType.STRING)
    private PhysicalStrength physicalStrength;

    private boolean planningWar;
    private boolean powers;

    public Alien() {

    }

    public Alien(long id, int iq, String planet, AlienType alienType, String language, int age, IqLevel iqLevel, PhysicalStrength physicalStrength, boolean planningWar, boolean powers) {
        this.id = id;
        this.iq = iq;
        this.planet = planet;
        this.alienType = alienType;
        this.language = language;
        this.age = age;
        this.iqLevel = iqLevel;
        this.physicalStrength = physicalStrength;
        this.planningWar = planningWar;
        this.powers = powers;
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

    public boolean isPowers() {
        return powers;
    }

    public void setPowers(boolean powers) {
        this.powers = powers;
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

}



//if i used lombork @NoArgConstructor,@AllArgConstructr,@Data for this entity
