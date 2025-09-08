package org.example.parkingservices.service.mapper;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.service.dto.CommunityDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommunityMapper {
    private final SpotMapper spotMapper;

    public CommunityDto toDto(Community community) {
        if (community == null) {
            return null;
        }
        CommunityDto communityDto = new CommunityDto();
        communityDto.setId(community.getId());
        communityDto.setName(community.getName());
        communityDto.setAddress(community.getAddress());
//        communityDto.setSpots(spotMapper.toDtos(community.getSpots()));
        communityDto.setTotalSpots(community.getSpots().size());
        return communityDto;
    }
}
