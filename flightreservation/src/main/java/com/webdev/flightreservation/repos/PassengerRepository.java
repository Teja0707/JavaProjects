package com.webdev.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.flightreservation.entities.Passenger;

public interface PassengerRepository extends JpaRepository<Passenger, Long> {

}
