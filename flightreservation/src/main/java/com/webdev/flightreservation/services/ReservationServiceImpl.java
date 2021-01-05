package com.webdev.flightreservation.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.flightreservation.dto.ReservationRequest;
import com.webdev.flightreservation.entities.Flight;
import com.webdev.flightreservation.entities.Passenger;
import com.webdev.flightreservation.entities.Reservation;
import com.webdev.flightreservation.repos.FlightRepository;
import com.webdev.flightreservation.repos.PassengerRepository;
import com.webdev.flightreservation.repos.ReservationRepository;
import com.webdev.flightreservation.util.EmailUtil;
import com.webdev.flightreservation.util.PdfGenerator;

@Service
@Transactional
public class ReservationServiceImpl implements IReservationService{
	
	
	private String EMAIL_ITINERARY_DIR_PATH = "C:\\Users\\saite\\OneDrive\\Documents\\reservations\\reservation";

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	PassengerRepository passengerRepository;
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	EmailUtil emailUtil;
	
	@Autowired
	PdfGenerator pdfGenerator;

	@Override
	public Reservation bookFlight(ReservationRequest request) {
		
		Passenger passenger = new Passenger();
		passenger.setFirstName(request.getPassengerFirstName());
		passenger.setLastName(request.getPassengerLastName());
		passenger.setEmail(request.getPassengerEmail());
		passenger.setPhone(request.getPassengerPhone());
		passengerRepository.save(passenger);
		
		Flight flight = flightRepository.getOne(request.getFlightId());
      	Reservation reservation = new Reservation();
		reservation.setPassenger(passenger);
		reservation.setFlight(flight);
		reservation.setCheckedIn(false);
		
				
		Reservation savedReservation = reservationRepository.save(reservation);
		
		String path = EMAIL_ITINERARY_DIR_PATH + savedReservation.getId()+".pdf"; //saved in this location
		pdfGenerator.generateItenary(savedReservation, path);
		emailUtil.sendItinerary(passenger.getEmail(), path);
		
		
		return savedReservation;
	}

}
