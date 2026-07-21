package com.soft_universe.tranneer.repositories;

import com.soft_universe.tranneer.entities.Alien;
import com.soft_universe.tranneer.enums.IqLevel;
import com.soft_universe.tranneer.enums.PhysicalStrength;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlienRepository extends JpaRepository<Alien,Long> {
    long countByHasPowersTrue();
    long countByPlanningWarTrue();
    long countByIqLevel(IqLevel iqLevel);

    @Query("SELECT AVG(a.iq) FROM Alien a")
    Double findAverageIq();

    Optional<Alien> findFirstByPhysicalStrength(PhysicalStrength physicalStrength);
    List<Alien> findByPlanningWarTrue();
}
