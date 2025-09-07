package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
