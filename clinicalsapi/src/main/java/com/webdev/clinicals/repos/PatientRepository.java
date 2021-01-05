package com.webdev.clinicals.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.clinicals.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

}
