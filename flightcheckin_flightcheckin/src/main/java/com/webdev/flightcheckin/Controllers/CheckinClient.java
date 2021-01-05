package com.webdev.flightcheckin.Controllers;

import com.webdev.flightcheckin.integration.FlightCheckinImpl;
import com.webdev.flightcheckin.integration.dto.Reservation;
import com.webdev.flightcheckin.integration.dto.ReservationUpdateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CheckinClient {

    @Autowired
    FlightCheckinImpl flightCheckin;

    @RequestMapping("startCheckin")
    public String startCheckin(){
        return "startCheckin";
    }

    @RequestMapping("displayReservation")
    public String displayReservation(@RequestParam("flightId") Long flightId, ModelMap modelMap){
        Reservation reservation = flightCheckin.findReservation(flightId);
        modelMap.addAttribute("reservation",reservation);
        return "displayReservation";

    }
    
    @RequestMapping("completeCheckIn")
    public String completeCheckIn(@RequestParam("reservationId")Long reservationId, @RequestParam("numberOfBags")int numberOfBags, ModelMap modelMap) {
    	ReservationUpdateRequest reservationUpdateRequest = new ReservationUpdateRequest();
    	reservationUpdateRequest.setId(reservationId);
    	reservationUpdateRequest.setCheckedIn(true);
    	reservationUpdateRequest.setNumberOfBags(numberOfBags);
    	Reservation reservation = flightCheckin.updateReservation(reservationUpdateRequest);
    	modelMap.addAttribute("reservation", reservation);
    	return "checkedIn";

    }
}
