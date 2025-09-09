package org.example.parkingservices.service.mapper;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Booking;
import org.example.parkingservices.service.SpotService;
import org.example.parkingservices.service.UserService;
import org.example.parkingservices.service.dto.BookingRequestDto;
import org.example.parkingservices.service.dto.BookingResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingMapper {
    private final UserService userService;
    private final SpotService spotService;

    public Booking toEntity(BookingRequestDto dto) {
        if (dto == null) {
            return null;
        }
        Booking booking = new Booking();
        booking.setUser(userService.getUserById(dto.getUserId()));
        booking.setSpot(spotService.getSpotById(dto.getSpotId()));
        booking.setStartTime(dto.getStartTime());
        booking.setEndTime(dto.getEndTime());
        booking.setStatus("PENDING");
        return booking;
    }

    public BookingResponseDto toDto(Booking booking) {
        if (booking == null) {
            return null;
        }
        BookingResponseDto dto = new BookingResponseDto();
        dto.setId(booking.getId());
        dto.setUserId(booking.getUser().getId());
        dto.setSpotId(booking.getSpot().getId());
        dto.setSpotNumber(booking.getSpot().getSpotNumber());
        dto.setStartTime(booking.getStartTime());
        dto.setEndTime(booking.getEndTime());
        dto.setStatus(booking.getStatus());
        return dto;
    }

    public List<BookingResponseDto> toDtos(List<Booking> bookings) {
        return bookings.stream().map(this::toDto).toList();
    }
}
