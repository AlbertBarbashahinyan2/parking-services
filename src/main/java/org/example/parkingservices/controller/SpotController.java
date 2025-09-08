package org.example.parkingservices.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.parkingservices.service.SpotService;
import org.example.parkingservices.service.dto.ParkingRequestDto;
import org.example.parkingservices.service.dto.SpotDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/spots")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

    @GetMapping("/{id}")
    public SpotDto getSpotById(@PathVariable Long id) {
        return spotService.getSpotDtoById(id);
    }

    @GetMapping("/community/{communityId}")
    public List<SpotDto> getSpotsByCommunityId(@PathVariable Long communityId) {
        return spotService.getSpotsByCommunityId(communityId);
    }

    @PostMapping("/{id}/park")
    public SpotDto parkInSpot(@PathVariable Long id,
                              @RequestBody @Valid ParkingRequestDto parkingRequestDto) {
        return spotService.parkInSpot(id, parkingRequestDto);
    }
}
