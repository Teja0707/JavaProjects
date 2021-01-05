package com.webdev.flightreservation.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.flightreservation.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
