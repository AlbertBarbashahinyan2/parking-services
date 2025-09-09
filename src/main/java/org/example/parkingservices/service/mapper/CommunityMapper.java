package org.example.parkingservices.service.mapper;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.service.dto.CommunityDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommunityMapper {

    public CommunityDto toDto(Community community) {
        if (community == null) {
            return null;
        }
        CommunityDto communityDto = new CommunityDto();
        communityDto.setId(community.getId());
        communityDto.setName(community.getName());
        communityDto.setAddress(community.getAddress());
        communityDto.setTotalSpots(community.getSpots().size());
        communityDto.setAvailableSpots((int) community.getSpots().stream()
                .filter(spot -> "AVAILABLE".equals(spot.getStatus()))
                .count());
        return communityDto;
    }
}
