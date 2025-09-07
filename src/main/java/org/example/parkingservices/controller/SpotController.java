package org.example.parkingservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.service.SpotService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spots")
@RequiredArgsConstructor
public class SpotController {
    private final SpotService spotService;
}
