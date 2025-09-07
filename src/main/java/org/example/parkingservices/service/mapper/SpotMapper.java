package org.example.parkingservices.service.mapper;

import org.example.parkingservices.persistence.entity.Spot;
import org.example.parkingservices.service.dto.SpotDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class SpotMapper {

    public SpotDto toDto(Spot spot) {
        if (spot == null) {
            return null;
        }
        SpotDto spotDto = new SpotDto();
        spotDto.setId(spot.getId());
        spotDto.setSpotNumber(spot.getSpotNumber());
        spotDto.setCommunityName(spot.getCommunity().getName());
        spotDto.setStatus(spot.getStatus());
        return spotDto;
    }

    public List<SpotDto> toDtos(List<Spot> spots) {
        if (spots == null) {
            return null;
        }
        return spots.stream().map(this::toDto).collect(Collectors.toList());
    }
    
}
