package com.webdev.clinicals.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.clinicals.dto.ClinicaldataRequest;
import com.webdev.clinicals.entities.Clinicaldata;
import com.webdev.clinicals.entities.Patient;
import com.webdev.clinicals.repos.ClinicaldataRepository;
import com.webdev.clinicals.repos.PatientRepository;
import com.webdev.clinicals.util.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ClinicaldataController {

	@Autowired
	private ClinicaldataRepository clinicaldataRepository;

	@Autowired
	private PatientRepository patientRepository;

	public ClinicaldataController(ClinicaldataRepository clinicaldataRepository, PatientRepository patientRepository) {
		super();
		this.clinicaldataRepository = clinicaldataRepository;
		this.patientRepository = patientRepository;
	}

	@RequestMapping(path = "/clinicals", method = RequestMethod.POST)
	public void saveClinicaldata(@RequestBody ClinicaldataRequest request) {
		Patient patient = patientRepository.findById(request.getPatientId()).get();

		Clinicaldata clinicaldata = new Clinicaldata();
		clinicaldata.setComponentName(request.getComponentName());
		clinicaldata.setComponentValue(request.getComponentValue());
		clinicaldata.setPatient(patient);

		clinicaldataRepository.save(clinicaldata);
	}

	@RequestMapping(path = "/clinicals/{patientId}/{componentName}", method = RequestMethod.GET)
	public List<Clinicaldata> getClinicaldata(@PathVariable("patientId") int patientId,
			@PathVariable("componentName") String componentName) {
		
		if(componentName.equals("bmi")) {
			componentName = "hw";
		}
		
		List<Clinicaldata> clinicaldata = clinicaldataRepository.findByPatientIdAndComponentName(patientId, componentName);
		ArrayList<Clinicaldata> duplicateData = new ArrayList<>(clinicaldata);
		for (Clinicaldata eachEntry : duplicateData) {

			BMICalculator.calculateBMI(clinicaldata, eachEntry);

		}
		return clinicaldata;

	}
}
