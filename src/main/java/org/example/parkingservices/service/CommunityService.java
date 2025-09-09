package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.exception.ResourceNotFoundException;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.persistence.repository.CommunityRepository;
import org.example.parkingservices.service.dto.CommunityDto;
import org.example.parkingservices.service.mapper.CommunityMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommunityService {
    private final CommunityRepository communityRepository;
    private final CommunityMapper communityMapper;

    public CommunityDto getCommunityById(Long id) {
        Community community = communityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Community not found with id: " + id));
        return communityMapper.toDto(community);
    }
}
