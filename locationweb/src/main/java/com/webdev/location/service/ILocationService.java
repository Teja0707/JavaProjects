package com.webdev.location.service;

import java.util.List;

import com.webdev.location.entities.Location;

public interface ILocationService {
	
	Location saveLocation(Location location);
	Location updateLocation(Location location);
	void deleteLocation(Location location);
	Location getLocationById(int id);
	List<Location> getAllLocations();
	
	

}
