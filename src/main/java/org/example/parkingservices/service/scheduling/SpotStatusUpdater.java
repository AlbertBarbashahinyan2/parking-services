package org.example.parkingservices.service.scheduling;

import lombok.RequiredArgsConstructor;
import org.example.parkingservices.persistence.repository.SpotRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class SpotStatusUpdater {
    private final SpotRepository spotRepository;

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void updateSpotStatuses() {
        spotRepository.updateSpotStatuses();
    }
}
