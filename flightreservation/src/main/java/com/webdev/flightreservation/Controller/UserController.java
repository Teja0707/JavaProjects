package com.webdev.flightreservation.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.webdev.flightreservation.entities.User;
import com.webdev.flightreservation.repos.UserRepository;


@Controller
public class UserController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/showRegistration")
	public String showRegistration() {

		LOGGER.info("Inside showRegistration()");
		
		return "login/registration";
	}

	@RequestMapping("/showlogin")
	public String showlogin() {
		
		LOGGER.info("Inside showlogin()");

		return "login/login";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String registerUser(@ModelAttribute("user") User user, ModelMap modelMap) {
		
		LOGGER.info("Inside registerUser(), user : " + user);

		userRepository.save(user);

		String msg = "User with Id " + user.getId() + " registered";
		modelMap.addAttribute("msg", msg);
		return "login/registration";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password,
			ModelMap modelMap) {
		
		LOGGER.info("Inside loginUser(), email: " + email);

		User user = userRepository.findByEmail(email);
		String msg;

		if (user.getPassword().equals(password)) {
			msg = "User logged in successfully";
			modelMap.addAttribute("msg",msg);
			return "findFlights";
		} else {
			msg = "Invalid user";
			modelMap.addAttribute("msg",msg);
			return "login/login";
		}
	}

}
