package org.example.parkingservices.service;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.entity.Booking;
import org.example.parkingservices.persistence.entity.Spot;
import org.example.parkingservices.persistence.repository.BookingRepository;
import org.example.parkingservices.persistence.repository.SpotRepository;
import org.example.parkingservices.service.dto.ParkingRequestDto;
import org.example.parkingservices.service.dto.SpotDto;
import org.example.parkingservices.service.mapper.SpotMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SpotService {
    private final SpotRepository spotRepository;
    private final SpotMapper spotMapper;
    private final BookingRepository bookingRepository;

    public SpotDto getSpotDtoById(Long id) {
        return spotMapper.toDto(spotRepository.findById(id).orElse(null));
    }

    public Spot getSpotById(Long id) {
        return spotRepository.findById(id).orElse(null);
    }

    public List<SpotDto> getSpotsByCommunityId(Long communityId) {
        List<Spot> spots = spotRepository.findByCommunityIdOrderById(communityId);
        return spotMapper.toDtos(spots);
    }

    public SpotDto parkInSpot(Long spotId, ParkingRequestDto parkingRequestDto) {
        Spot spot = getSpotById(spotId);
        if (spot == null) {
            throw new IllegalArgumentException("Spot not found.");
        }
        if (spot.getStatus().equals("OCCUPIED")) {
            throw new IllegalStateException("Spot is already occupied.");
        }
        Booking booking = bookingRepository.findById(parkingRequestDto.getBookingId()).orElse(null);
        if (booking == null || !booking.getSpot().getId().equals(spotId) ||
        !booking.getUser().getId().equals(parkingRequestDto.getUserId()) ||
        !booking.getStatus().equals("IN_PROGRESS")) {
            throw new IllegalArgumentException("Invalid booking for this spot.");
        }
        spot.setStatus("OCCUPIED");
        spotRepository.save(spot);
        return spotMapper.toDto(spot);
    }
}
