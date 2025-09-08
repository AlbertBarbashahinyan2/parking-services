package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Spot;
import org.example.parkingservices.persistence.repository.SpotRepository;
import org.example.parkingservices.service.dto.SpotDto;
import org.example.parkingservices.service.mapper.SpotMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;
    private final SpotMapper spotMapper;

    public SpotDto getSpotDtoById(Long id) {
        return spotMapper.toDto(spotRepository.findById(id).orElse(null));
    }

    public Spot getSpotById(Long id) {
        return spotRepository.findById(id).orElse(null);
    }

    public List<SpotDto> getSpotsByCommunityId(Long communityId) {
        List<Spot> spots = spotRepository.findByCommunityId(communityId);
        return spotMapper.toDtos(spots);
    }
}
