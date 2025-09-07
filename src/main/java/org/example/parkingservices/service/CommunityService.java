package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.repository.CommunityRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;
}
