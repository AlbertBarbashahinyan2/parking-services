package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.exception.ResourceNotFoundException;
import org.example.parkingservices.persistence.entity.User;
import org.example.parkingservices.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("User not found with id: " + id)
        );
    }
}
