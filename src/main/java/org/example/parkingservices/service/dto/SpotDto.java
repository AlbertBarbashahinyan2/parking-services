package org.example.parkingservices.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SpotDto {
    private Long id;

    @NotBlank(message = "Spot number is mandatory")
    private String spotNumber;

    @NotBlank(message = "Community name is mandatory")
    private String communityName;

    @NotBlank(message = "Status is mandatory")
    private String status;
}
