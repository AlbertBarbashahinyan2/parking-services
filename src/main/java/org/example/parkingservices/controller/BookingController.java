package org.example.parkingservices.controller;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.service.BookingService;
import org.example.parkingservices.service.dto.BookingRequestDto;
import org.example.parkingservices.service.dto.BookingResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookings")
@RequiredArgsConstructor
public class BookingController {
    private final BookingService bookingService;

    @PostMapping
    public BookingResponseDto createBooking(@RequestBody BookingRequestDto bookingRequestDto) {
        return bookingService.createBooking(bookingRequestDto);
    }

    @DeleteMapping("/{bookingId}")
    public void cancelBooking(@PathVariable Long bookingId) {
        bookingService.cancelBooking(bookingId);
    }

    @GetMapping("/{id}")
    public BookingResponseDto getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @GetMapping("community/{communityId}")
    public List<BookingResponseDto> getBookingsForCommunity(@PathVariable Long communityId) {
        return bookingService.getBookingsForCommunity(communityId);
    }
}
