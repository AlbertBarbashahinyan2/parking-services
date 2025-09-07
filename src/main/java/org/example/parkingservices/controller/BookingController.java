package org.example.parkingservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.service.BookingService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;
}
