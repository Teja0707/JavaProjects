package com.webdev.vendor.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.vendor.entities.Vendor;
import com.webdev.vendor.services.VendorServiceImpl;
import com.webdev.vendor.utils.IEmailUtil;

@Controller
public class VendorController {
	
	@Autowired
	VendorServiceImpl service;
	
	@Autowired
	IEmailUtil emailUtil;
	
	@RequestMapping("/showCreate")
	public String showCreate() {
		return "createVendor";
	}
	
	@RequestMapping("/saveVendor")
	public String saveVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap) {
		
		Vendor savedVendor = service.saveVendor(vendor);
		String msg = "Vendor with Id " + savedVendor.getId() + " saved to DB";
		modelMap.addAttribute("msg", msg);
		emailUtil.sendEmail("saiteja.lfa7@gmail.com", "Location saved", "Set life - location saved");
		return "createVendor";
	}
	
	@RequestMapping("/viewVendors")
	public String viewVendors(ModelMap modelMap) {
		
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "viewVendors";
	}
	
	@RequestMapping("/deleteVendor")
	public String deleteVendor(@RequestParam("id")int id,ModelMap modelMap) {
	
		// get vendor by Id and delete vendor
		Vendor vendor = service.getVendorById(id);
		String msg = "Vendor with Id " + vendor.getId() + " deleted";
		service.deleteVendor(vendor);
		modelMap.addAttribute("msg",msg);
		// show list
		List<Vendor> vendors = service.getAllVendors();
		modelMap.addAttribute("vendors", vendors);
		return "viewVendors";
	}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int id,ModelMap modelMap) {
		
		Vendor vendor = service.getVendorById(id);
		modelMap.addAttribute("vendor", vendor);
		return "updateVendor";
	}
	
	@RequestMapping("/updateVendor")
	public String updateVendor(@ModelAttribute("vendor") Vendor vendor,ModelMap modelMap) {
		
		
				Vendor updatedVendor = service.updateVendor(vendor);
				String msg = "Vendor with Id " + updatedVendor.getId() + " changed";
				service.deleteVendor(vendor);
				modelMap.addAttribute("msg",msg);
				// show list
				List<Vendor> vendors = service.getAllVendors();
				modelMap.addAttribute("vendors", vendors);
				return "viewVendors";
		
	}
}
