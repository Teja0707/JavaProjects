package com.webdev.flightcheckin.integration;

import com.webdev.flightcheckin.integration.dto.Reservation;
import com.webdev.flightcheckin.integration.dto.ReservationUpdateRequest;

public interface IFlightCheckIn {

    Reservation findReservation(Long flightId);
    Reservation updateReservation(ReservationUpdateRequest request);
}
