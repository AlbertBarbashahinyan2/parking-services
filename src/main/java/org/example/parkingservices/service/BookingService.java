package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
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
        return bookingMapper.toDtos(bookings);
    }



    private boolean hasOverlap(Booking newBooking, List<Booking> existingBookings) {
        return existingBookings.stream().anyMatch(existing ->
                newBooking.getStartTime().isBefore(existing.getEndTime()) &&
                        newBooking.getEndTime().isAfter(existing.getStartTime())
        );
    }

    public BookingResponseDto getBookingById(long bookingId) {
        return bookingMapper.toDto(bookingRepository.findById(bookingId).orElse(null));
    }
}
