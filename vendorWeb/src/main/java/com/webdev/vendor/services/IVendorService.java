package com.webdev.vendor.services;

import java.util.List;

import com.webdev.vendor.entities.Vendor;

public interface IVendorService {
	
	/*
	save, update, delete, findbyId,	findall
	*/
	
	Vendor saveVendor(Vendor vendor);
	Vendor updateVendor(Vendor vendor);
	void deleteVendor(Vendor vendor);
	Vendor getVendorById(int id);
	List<Vendor> getAllVendors();

}
