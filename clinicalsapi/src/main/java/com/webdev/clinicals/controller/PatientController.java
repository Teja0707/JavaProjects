package com.webdev.clinicals.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.clinicals.entities.Clinicaldata;
import com.webdev.clinicals.entities.Patient;
import com.webdev.clinicals.repos.ClinicaldataRepository;
import com.webdev.clinicals.repos.PatientRepository;
import com.webdev.clinicals.util.BMICalculator;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class PatientController {

	@Autowired
	private PatientRepository patientRepository;
	
	Map<String,String> filters = new HashMap<>();
	
	@Autowired
	private ClinicaldataRepository clinicaldataRepository;

	public PatientController(PatientRepository patientRepository, ClinicaldataRepository clinicaldataRepository) {
		this.patientRepository = patientRepository;
		this.clinicaldataRepository = clinicaldataRepository;
	}
	
	@RequestMapping(path = "/patients",method = RequestMethod.GET)
	public List<Patient> getPatients(){
		return patientRepository.findAll();
	}
	
	@RequestMapping(path = "/patients/{id}",method = RequestMethod.GET)
	public Patient getPatientById(@PathVariable("id") int id){
		return patientRepository.findById(id).get();
	}
	
	@RequestMapping(path = "patients",method = RequestMethod.POST)
	public Patient savePatient(@RequestBody Patient patient){
		return patientRepository.save(patient);
	}
	
	@RequestMapping(path = "patients/analyze/{id}",method = RequestMethod.GET)
	public Patient analyzePatient(@PathVariable("id") int id) {
		
		Patient patient = patientRepository.findById(id).get();
		List<Clinicaldata> clinicaldata = patient.getClinicalData();
		ArrayList<Clinicaldata> duplicateData = new ArrayList<>(clinicaldata);
		for(Clinicaldata eachEntry : duplicateData) {
			
			if(filters.containsKey(eachEntry.getComponentName())) {
				clinicaldata.remove(eachEntry);
			}else {
				filters.put(eachEntry.getComponentName(), null);
			}
			
			BMICalculator.calculateBMI(clinicaldata, eachEntry);
			
		}
		filters.clear();
		return patient;
	}

	
}
