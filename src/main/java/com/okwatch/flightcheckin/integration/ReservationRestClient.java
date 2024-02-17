package com.okwatch.flightcheckin.integration;

import com.okwatch.flightcheckin.integration.dto.Reservation;
import com.okwatch.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface ReservationRestClient {
    public Reservation findReservation(Long id);

    public Reservation updateReservation(ReservationUpdateRequest request);
}
