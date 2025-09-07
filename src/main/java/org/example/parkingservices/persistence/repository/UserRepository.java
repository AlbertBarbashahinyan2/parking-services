package org.example.parkingservices.persistence.repository;

import org.example.parkingservices.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
