package com.webdev.clinicals.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.clinicals.entities.Clinicaldata;

public interface ClinicaldataRepository extends JpaRepository<Clinicaldata, Integer> {

	List<Clinicaldata> findByPatientIdAndComponentName(int patientId, String componentName);

}
