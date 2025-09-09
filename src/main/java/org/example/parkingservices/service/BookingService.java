package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.exception.ResourceNotFoundException;
import org.example.parkingservices.exception.IllegalArgumentException;
import org.example.parkingservices.persistence.entity.Booking;
import org.example.parkingservices.persistence.repository.BookingRepository;
import org.example.parkingservices.service.dto.BookingRequestDto;
import org.example.parkingservices.service.dto.BookingResponseDto;
import org.example.parkingservices.service.mapper.BookingMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {
    private final BookingRepository bookingRepository;
    private final BookingMapper bookingMapper;

    public BookingResponseDto createBooking(BookingRequestDto bookingRequestDto) {
        Booking booking = bookingMapper.toEntity(bookingRequestDto);
        List<Booking> existingBookings = bookingRepository.findBySpotId(booking.getSpot().getId());
        if (booking.getStartTime().isAfter(booking.getEndTime()) ||
            booking.getStartTime().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Invalid booking time range.");
        }
        if (hasOverlap(booking, existingBookings)) {
            throw new IllegalArgumentException("Booking time overlaps with an existing booking.");
        }

        bookingRepository.save(booking);
        return bookingMapper.toDto(booking);
    }

    public List<BookingResponseDto> getBookingsForCommunity(Long communityId){
        List<Booking> bookings = bookingRepository.findByCommunityId(communityId);
        if (bookings == null || bookings.isEmpty()) {
            throw new ResourceNotFoundException("No community found with id " + communityId);
        }
        return bookingMapper.toDtos(bookings);
    }



    private boolean hasOverlap(Booking newBooking, List<Booking> existingBookings) {
        return existingBookings.stream().anyMatch(existing ->
                newBooking.getStartTime().isBefore(existing.getEndTime()) &&
                        newBooking.getEndTime().isAfter(existing.getStartTime())
        );
    }

    public BookingResponseDto getBookingById(long bookingId) {
        Booking booking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new ResourceNotFoundException("Booking not found with id: " + bookingId));
        return bookingMapper.toDto(booking);
    }
}
