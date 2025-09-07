package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.repository.BookingRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
}
