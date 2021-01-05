package org.webdev.model;

import java.util.ArrayList;
import java.util.List;

public class Devices {

	List<Device> devices = new ArrayList<>();
	String brandName;

	public Devices() {
	}

	public Devices(List<Device> devices) {
		this.devices = devices;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

	public String getBrandName() {
		return brandName;
	}

	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	@Override
	public String toString() {
		return "Devices [devices=" + devices + ", brandName=" + brandName + "]";
	}

	
}
