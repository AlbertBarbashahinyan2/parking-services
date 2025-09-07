package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Long> {

}
