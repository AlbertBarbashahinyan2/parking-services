package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.persistence.entity.Spot;
import org.example.parkingservices.persistence.repository.SpotRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;

//    public List<Spot> getAvailableSpots(Community community) {
//        return spotRepository.findByCommunityAndIsAvailable(community, true);
//    }
}
