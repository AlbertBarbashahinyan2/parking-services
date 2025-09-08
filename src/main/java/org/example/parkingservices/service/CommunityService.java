package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
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
        return communityMapper.toDto(communityRepository.findById(id).orElse(null));
    }
}
