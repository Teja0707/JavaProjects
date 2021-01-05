package com.webdev.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webdev.vendor.entities.Vendor;
import com.webdev.vendor.repos.VendorRepository;

@RestController
@RequestMapping("/vendors")
public class VendorRestController {
	
	
	@Autowired
	VendorRepository repository;
	
	
	/* GET POST PUT DELETE */
	
	@GetMapping
	public List<Vendor> getVendorList(){
		return repository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public Vendor getVendorById(@PathVariable("id") int id) {
		Vendor vendor = repository.findById(id).get();
		return vendor;
	}
	
	@PostMapping
	public void saveVendor(@RequestBody Vendor vendor) {
		repository.save(vendor);
	}
	
	@PutMapping
	public void updateVendor(@RequestBody Vendor vendor) {
		repository.save(vendor);
	}
	
	@DeleteMapping("/{id}")
	public void deleteVendor(@PathVariable("id") int id) {
		repository.deleteById(id);
	}
	
}
