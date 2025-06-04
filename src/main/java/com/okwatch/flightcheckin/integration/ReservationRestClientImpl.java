package com.okwatch.flightcheckin.integration;

import com.okwatch.flightcheckin.integration.dto.Reservation;
import com.okwatch.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class ReservationRestClientImpl implements ReservationRestClient {

    public static final String FIND_URL = "http://localhost:8080/reservations/";
    public static final String UPDATE_URL = "http://localhost:8080/reservations";


    @Override
    public Reservation findReservation(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.getForObject(FIND_URL + id, Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        RestTemplate restTemplate = new RestTemplate();
        Reservation reservation = restTemplate.postForObject(UPDATE_URL, request, Reservation.class);

        return reservation;
    }
}
