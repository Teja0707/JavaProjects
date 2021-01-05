package org.webdev.store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.webdev.model.Devices;

@Controller
public class Store {
	
	private ModelAndView modelAndView;
	private Devices result;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/{brandName}")
	public ModelAndView samsung(@PathVariable("brandName") String brandName) {
		
		modelAndView = new ModelAndView("viewDevices");
		
		switch(brandName.toLowerCase()) {
		
		case "samsung" :	
			
			result = restTemplate.getForObject("http://SAMSUNG/samsung/devices", Devices.class);
			modelAndView.addObject("devices",result);
			return modelAndView;
//			localhost:8091
			
		case "apple" :
			
			result = restTemplate.getForObject("http://APPLE/apple/devices", Devices.class);
			modelAndView.addObject("devices",result);
			return modelAndView;
			
		default :
			
			return new ModelAndView("redirect : /error");
		
		
		}	
			
	}
	
}
