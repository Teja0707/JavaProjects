package com.webdev.flightreservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.flightreservation.dto.ReservationRequest;
import com.webdev.flightreservation.entities.Flight;

import com.webdev.flightreservation.entities.Reservation;
import com.webdev.flightreservation.repos.FlightRepository;
import com.webdev.flightreservation.services.ReservationServiceImpl;


@Controller
public class ReservationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

	@Autowired
	FlightRepository flightRepository;
	
	@Autowired
	ReservationServiceImpl service;
	
	@RequestMapping("/showCompleteReservation")
	public String showCompleteReservation(@RequestParam("id") long id, ModelMap modelMap) {
		
		LOGGER.info("Inside showCompleteReservation(), id: " +id);
		
		Flight flight = flightRepository.findById(id).get();
		System.out.println(flight.getFlightNumber());
		modelMap.addAttribute("flight", flight);
		return "completeReservation";
	}
	
	@RequestMapping("/completeReservation")
	public String completeReservation(@ModelAttribute("request") ReservationRequest request, ModelMap modelMap) {
		
		LOGGER.info("Inside completeReservation(), ReservationRequest: " + request);
		
		Reservation reservation = service.bookFlight(request);
		
		modelMap.addAttribute("reservation", reservation);
			
		return "showBooking";
	}
	
}
