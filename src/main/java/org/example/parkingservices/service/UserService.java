package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
}
