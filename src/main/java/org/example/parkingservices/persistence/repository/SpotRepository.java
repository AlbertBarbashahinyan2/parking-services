package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpotRepository extends JpaRepository<Spot, Long> {

    @Modifying
    @Query("UPDATE Spot s " +
            "SET s.status = CASE " +
            "    WHEN EXISTS (" +
            "        SELECT b FROM Booking b " +
            "        WHERE b.spot.id = s.id AND b.status = 'IN_PROGRESS'" +
            "    ) THEN 'BOOKED' " +
            "    ELSE 'AVAILABLE' " +
            "END")
    void updateSpotStatuses();

    List<Spot> findByCommunityIdOrderById(Long communityId);
}
