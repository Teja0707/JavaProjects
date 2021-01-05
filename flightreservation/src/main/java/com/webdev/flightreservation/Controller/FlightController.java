package com.webdev.flightreservation.Controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.flightreservation.entities.Flight;
import com.webdev.flightreservation.repos.FlightRepository;

@Controller
public class FlightController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class); 
	
	@Autowired
	FlightRepository flightRepository;

	@RequestMapping(value = "findFlights")
	public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
			@RequestParam("dateOfDeparture") @DateTimeFormat(pattern = "MM-dd-yyyy") Date dateOfDeparture,
			ModelMap modelMap) {

		LOGGER.info("Inside findFlights() method " +" ,from: " + from + " ,to: " + to +" ,dateOfDeparture: " +dateOfDeparture);
		
		List<Flight> flights = flightRepository.findFlights(from, to, dateOfDeparture);
		modelMap.addAttribute("flights", flights);
		return "displayFlights";
	}

}
