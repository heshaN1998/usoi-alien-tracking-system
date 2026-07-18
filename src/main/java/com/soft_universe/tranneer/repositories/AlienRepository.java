package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.enums.IqLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlienRepository extends JpaRepository<Alien,Long> {
    long countByHasPowersTrue();
    long countByPlanningWarTrue();
    long countByIqLevel(IqLevel iqLevel);

    @Query("SELECT AVG(a.iq) FROM Alien a")
    Double averageIq();
}
