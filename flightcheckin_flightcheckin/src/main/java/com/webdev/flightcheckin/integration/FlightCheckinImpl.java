package com.webdev.flightcheckin.integration;

import com.webdev.flightcheckin.integration.dto.Reservation;
import com.webdev.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FlightCheckinImpl implements IFlightCheckIn {

    String FLIGHT_RESERVATION_REST_URL = "http://localhost:8090/flightreservationweb/reservations/";
    RestTemplate restTemplate = new RestTemplate();

    @Override
    public Reservation findReservation(Long flightId) {
        Reservation reservation = restTemplate.getForObject(FLIGHT_RESERVATION_REST_URL+ flightId,Reservation.class);
        return reservation;
    }

    @Override
    public Reservation updateReservation(ReservationUpdateRequest request) {
        Reservation reservation = restTemplate.postForObject(FLIGHT_RESERVATION_REST_URL,request,Reservation.class);
        return reservation;
    }
}
