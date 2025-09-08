package org.example.parkingservices.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ParkingRequestDto {
    @NotBlank(message = "user id must not be blank")
    private long userId;

    @NotBlank(message = "booking id must not be blank")
    private long bookingId;
}
