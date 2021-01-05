package com.webdev.clinicals.entities;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Clinicaldata {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String componentName;
	private String componentValue;
	private Timestamp measuredDateTime;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientId",nullable = false)
	@JsonIgnore
	private Patient patient;
	
	
	public Clinicaldata() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComponentName() {
		return componentName;
	}
	public void setComponentName(String componentName) {
		this.componentName = componentName;
	}
	public String getComponentValue() {
		return componentValue;
	}
	public void setComponentValue(String componentValue) {
		this.componentValue = componentValue;
	}
	public Timestamp getMeasuredDateTime() {
		return measuredDateTime;
	}
	public void setMeasuredDateTime(Timestamp measuredDateTime) {
		this.measuredDateTime = measuredDateTime;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	@Override
	public String toString() {
		return "Clinicaldata [id=" + id + ", componentName=" + componentName + ", componentValue=" + componentValue
				+ ", measuredDateTime=" + measuredDateTime + "]";
	}
	
	
}
