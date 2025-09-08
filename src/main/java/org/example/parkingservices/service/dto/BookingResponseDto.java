package org.example.parkingservices.service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class BookingResponseDto {
    @NotBlank(message = "User ID is mandatory")
    private Long userId;

    @NotBlank(message = "Spot ID is mandatory")
    private Long spotId;

    @NotNull(message = "Start time is mandatory")
    private LocalDateTime startTime;

    @NotNull(message = "End time is mandatory")
    private LocalDateTime endTime;

    @NotBlank(message = "Status is mandatory")
    private String status;
}