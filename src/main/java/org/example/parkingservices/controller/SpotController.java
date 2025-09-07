package org.example.parkingservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Community;
import org.example.parkingservices.persistence.entity.Spot;
import org.example.parkingservices.service.SpotService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/spots")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;

//    @GetMapping("/available")
//    public List<Spot> getAvailableSpots(Community community) {
//        return spotService.getAvailableSpots(community);
//    }
}
