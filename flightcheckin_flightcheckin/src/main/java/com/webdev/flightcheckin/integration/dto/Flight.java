package com.webdev.flightcheckin.integration.dto;

import java.sql.Timestamp;
import java.util.Date;


public class Flight {

	private long id;
	
	private String flightNumber;
	
	private String operatingAirlines;
	
	private String departureCity;
	
	private String arrivalCity;
	
	private Date dateOfDeparture;
	
	private Timestamp estimatedDepartureTime;
	
	public Flight() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Flight(String flightNumber, String operatingAirlines, String departureCity, String arrivalCity,
			Date dateOfDeparture, Timestamp estimatedDepartureTime) {
		super();
		this.flightNumber = flightNumber;
		this.operatingAirlines = operatingAirlines;
		this.departureCity = departureCity;
		this.arrivalCity = arrivalCity;
		this.dateOfDeparture = dateOfDeparture;
		this.estimatedDepartureTime = estimatedDepartureTime;
	}



	public String getFlightNumber() {
		return flightNumber;
	}


	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}


	public String getOperatingAirlines() {
		return operatingAirlines;
	}


	public void setOperatingAirlines(String operatingAirlines) {
		this.operatingAirlines = operatingAirlines;
	}


	public String getDepartureCity() {
		return departureCity;
	}


	public void setDepartureCity(String departureCity) {
		this.departureCity = departureCity;
	}


	public String getArrivalCity() {
		return arrivalCity;
	}


	public void setArrivalCity(String arrivalCity) {
		this.arrivalCity = arrivalCity;
	}


	public Date getDateOfDeparture() {
		return dateOfDeparture;
	}


	public void setDateOfDeparture(Date dateOfDeparture) {
		this.dateOfDeparture = dateOfDeparture;
	}


	public Timestamp getEstimatedDepartureTime() {
		return estimatedDepartureTime;
	}


	public void setEstimatedDepartureTime(Timestamp estimatedDepartureTime) {
		this.estimatedDepartureTime = estimatedDepartureTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Flight [flightNumber=" + flightNumber + ", operatingAirlines=" + operatingAirlines + ", departureCity="
				+ departureCity + ", arrivalCity=" + arrivalCity + ", dateOfDeparture=" + dateOfDeparture
				+ ", estimatedDepartureTime=" + estimatedDepartureTime + "]";
	}

	
	

}
