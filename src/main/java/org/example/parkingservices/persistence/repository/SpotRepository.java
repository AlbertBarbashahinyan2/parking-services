package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Spot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpotRepository extends JpaRepository<Spot, Long> {
}
