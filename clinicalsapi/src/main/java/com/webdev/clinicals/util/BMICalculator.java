package com.webdev.clinicals.util;

import java.util.List;

import com.webdev.clinicals.entities.Clinicaldata;

public class BMICalculator {
	

	public static void calculateBMI(List<Clinicaldata> clinicaldata, Clinicaldata eachEntry) {
		if(eachEntry.getComponentName().equals("hw")) {
		
			String[] heightAndWeight = eachEntry.getComponentValue().split("/");
			if(heightAndWeight != null && heightAndWeight.length > 1) {
				float heightInMeters = Float.parseFloat(heightAndWeight[0])*0.4536F;
				float bmi = Float.parseFloat(heightAndWeight[1]) / (heightInMeters  * heightInMeters );
				Clinicaldata bmiData = new Clinicaldata();
				bmiData.setComponentName("bmi");
				bmiData.setComponentValue(Float.toString(bmi));
				clinicaldata.add(bmiData);
				
			}
		}
	}

}
