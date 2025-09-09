package org.example.parkingservices.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingResponseDto {
    @NotNull(message = "Booking ID is mandatory")
    private Long id;

    @NotNull(message = "User ID is mandatory")
    private Long userId;

    @NotNull(message = "Spot ID is mandatory")
    private Long spotId;

    @NotBlank(message = "Spot number is mandatory")
    private String spotNumber;

    @NotNull(message = "Start time is mandatory")
    private LocalDateTime startTime;

    @NotNull(message = "End time is mandatory")
    private LocalDateTime endTime;

    @NotBlank(message = "Status is mandatory")
    private String status;
}