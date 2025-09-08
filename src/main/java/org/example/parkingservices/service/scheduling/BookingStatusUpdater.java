package org.example.parkingservices.service.scheduling;

import org.example.parkingservices.persistence.repository.BookingRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Component
public class BookingStatusUpdater {
    private final BookingRepository bookingRepository;

    public BookingStatusUpdater(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Scheduled(fixedRate = 60000)
    @Transactional
    public void updateBookingStatuses() {
        LocalDateTime now = LocalDateTime.now();
        bookingRepository.updateExpiredBookings(now);
        bookingRepository.updateInProgressBookings(now);
    }
}
