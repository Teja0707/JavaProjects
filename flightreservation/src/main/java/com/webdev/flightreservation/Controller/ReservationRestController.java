package com.webdev.flightreservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.flightreservation.dto.ReservationUpdateRequest;
import com.webdev.flightreservation.entities.Reservation;
import com.webdev.flightreservation.repos.ReservationRepository;

@RestController
@CrossOrigin
public class ReservationRestController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);
	
	@Autowired
	ReservationRepository reservationRepository;
	
	
	@RequestMapping("reservations/{id}")
	public Reservation getReservation(@PathVariable("id") Long id) {
		
		LOGGER.info("Inside getReservation(), id: " +id);
		
		return reservationRepository.findById(id).get();
	}
	
	@RequestMapping("reservations")
	public Reservation updateReservation(@RequestBody ReservationUpdateRequest request) {
		
		LOGGER.info("Inside updateReservation(), ReservationUpdateRequest: " +request);
		
		Reservation reservation =  reservationRepository.findById(request.getId()).get();
		reservation.setNumberOfBags(request.getNumberOfBags());
		reservation.setCheckedIn(request.isCheckedIn());
		
		return reservationRepository.save(reservation);
			
	}

}
