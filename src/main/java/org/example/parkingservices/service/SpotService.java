package org.example.parkingservices.service;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.parkingservices.exception.ResourceAlreadyUsedException;
import org.example.parkingservices.exception.ResourceNotFoundException;
import org.example.parkingservices.exception.IllegalArgumentException;
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
        return spotMapper.toDto(spotRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Spot not found with id: " + id)
        ));
    }

    public Spot getSpotById(Long id) {
        return spotRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Spot not found with id: " + id)
        );
    }

    public List<SpotDto> getSpotsByCommunityId(Long communityId) {
        List<Spot> spots = spotRepository.findByCommunityIdOrderById(communityId);
        if (spots == null || spots.isEmpty()) {
            throw new ResourceNotFoundException("No community found with id " + communityId);
        }
        return spotMapper.toDtos(spots);
    }

    public SpotDto parkInSpot(Long spotId, ParkingRequestDto parkingRequestDto) {
        Spot spot = getSpotById(spotId);
        if (spot.getStatus().equals("OCCUPIED")) {
            throw new ResourceAlreadyUsedException("Spot with id " + spotId + " is already occupied.");
        }
        Booking booking = bookingRepository.findById(parkingRequestDto.getBookingId()).orElseThrow(
                () -> new ResourceNotFoundException("Booking not found with id: " +
                        parkingRequestDto.getBookingId())
        );
        if (!booking.getSpot().getId().equals(spotId) ||
        !booking.getUser().getId().equals(parkingRequestDto.getUserId()) ||
        !booking.getStatus().equals("IN_PROGRESS")) {
            throw new IllegalArgumentException("Invalid booking for this spot.");
        }
        spot.setStatus("OCCUPIED");
        spotRepository.save(spot);
        return spotMapper.toDto(spot);
    }

    public SpotDto releaseSpot(Long spotId, @Valid ParkingRequestDto parkingRequestDto) {
        Spot spot = getSpotById(spotId);
        if (spot.getStatus().equals("AVAILABLE")) {
            throw new ResourceAlreadyUsedException("Spot with id " + spotId + " is already available.");
        }
        Booking booking = bookingRepository.findById(parkingRequestDto.getBookingId()).orElseThrow(
                () -> new ResourceNotFoundException("Booking not found with id: " +
                        parkingRequestDto.getBookingId())
        );
        if (!booking.getSpot().getId().equals(spotId) ||
                !booking.getUser().getId().equals(parkingRequestDto.getUserId()) ||
                booking.getStatus().equals("PENDING")) {
            throw new IllegalArgumentException("Invalid booking for this spot.");
        }
        spot.setStatus("AVAILABLE");
        spotRepository.save(spot);
        return spotMapper.toDto(spot);
    }
}
