package com.webdev.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.location.entities.Location;
import com.webdev.location.service.LocationServiceImpl;

@Controller
public class LocationController {
	
	@Autowired
	LocationServiceImpl service;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createLocation";
	}
	
	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
		Location savedLocation = service.saveLocation(location);
		String msg = "Location with Id " + savedLocation.getId() + " is saved to DB";
		modelMap.addAttribute("msg",msg);
		return "createLocation";
	}
	
	@RequestMapping("/viewLocations")
	public String viewLocations(ModelMap modelMap) {
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "viewLocations";
		
	}
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int id, ModelMap modelMap) {
		
		//delete with id
		Location location = service.getLocationById(id);
		String msg = "Location with Id " + location.getId() + " is deleted";
		service.deleteLocation(location);
		modelMap.addAttribute("msg",msg);
		//view locations
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		return "viewLocations";
		
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdatePage(@RequestParam("id")int id, ModelMap modelMap) {
		//send location to update to page
	    Location location = service.getLocationById(id);
	    modelMap.addAttribute("location",location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLocation")
	public String updateLocation(@ModelAttribute("location")Location location, ModelMap modelMap) {
		
		//edit location with id
		service.updateLocation(location);
		
		//update message
		String msg = "Location with Id " + location.getId() + " is changed";
		modelMap.addAttribute("msg",msg);
		
		//direct to view locations
		List<Location> locations = service.getAllLocations();
		modelMap.addAttribute("locations", locations);
		
		return "viewLocations";
	}

}
