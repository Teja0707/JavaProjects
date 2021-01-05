package com.webdev.flightreservation.services;

import com.webdev.flightreservation.dto.ReservationRequest;
import com.webdev.flightreservation.entities.Reservation;

public interface IReservationService {
	
	Reservation bookFlight(ReservationRequest request);

}
