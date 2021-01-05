package com.webdev.vendor.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webdev.vendor.entities.Vendor;

public interface VendorRepository extends JpaRepository<Vendor, Integer> {

}
