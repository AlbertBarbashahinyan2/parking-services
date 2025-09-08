package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Booking;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.persistence.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
