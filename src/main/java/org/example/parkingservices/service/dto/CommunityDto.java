package org.example.parkingservices.service.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CommunityDto {
    private Long id;

    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Address is mandatory")
    private String address;

    private List<SpotDto> spots;
}
