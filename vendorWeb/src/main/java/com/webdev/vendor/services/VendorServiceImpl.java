package com.webdev.vendor.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webdev.vendor.entities.Vendor;
import com.webdev.vendor.repos.VendorRepository;

@Service
public class VendorServiceImpl implements IVendorService {

	@Autowired
	VendorRepository repository;
	
	@Override
	public Vendor saveVendor(Vendor vendor) {
		return repository.save(vendor);
	}

	
	@Override
	public Vendor updateVendor(Vendor vendor) {
		return repository.save(vendor);
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		int id = vendor.getId();
		repository.deleteById(id);

	}

	@Override
	public Vendor getVendorById(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Vendor> getAllVendors() {
		return repository.findAll();
	}

}
