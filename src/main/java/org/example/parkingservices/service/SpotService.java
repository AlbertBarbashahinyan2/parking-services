package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.repository.SpotRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;
}
