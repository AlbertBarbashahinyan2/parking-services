package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findBySpotId(Long spotId);

    @Modifying
    @Query("UPDATE Booking b SET b.status = 'EXPIRED' WHERE b.endTime < :now AND b.status <> 'EXPIRED'")
    void updateExpiredBookings(LocalDateTime now);

    @Modifying
    @Query("UPDATE Booking b SET b.status = 'IN_PROGRESS' WHERE b.startTime < :now " +
            "AND b.status <> 'IN_PROGRESS' AND b.status <> 'EXPIRED'")
    void updateInProgressBookings(LocalDateTime now);

    @Query("SELECT b FROM Booking b WHERE b.spot.community.id = :communityId " +
            "ORDER BY b.startTime ASC")
    List<Booking> findByCommunityId(Long communityId);
}
